package com.lerhyd.dngame.config;

import com.google.common.collect.ImmutableList;
import com.lerhyd.dngame.dao.RoleDao;
import com.lerhyd.dngame.dao.RuleDao;
import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.filters.GoogleFilter;
import com.lerhyd.dngame.filters.VkFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.Filter;
import javax.sql.DataSource;

@SuppressWarnings("Duplicates")
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RuleDao ruleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    private final SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    @Qualifier("oauth2ClientContext")
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(ImmutableList.of("*"));
        corsConfiguration.setAllowedMethods(ImmutableList.of("POST", "GET"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(ImmutableList.of("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery("select login, password, true from users where login=?")
                .authoritiesByUsernameQuery("select login, role from user_role where login=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(googleFilter(), SecurityContextPersistenceFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/vk"));
        http
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(vkFilter(), SecurityContextPersistenceFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/vk"));

        http
                .csrf().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(restAuthenticationEntryPoint)

                .and()
                    .authorizeRequests()
                        .mvcMatchers("/").permitAll()
                        .antMatchers("/contacts", "/auth/check", "/game/rules").permitAll()
                        .antMatchers("/main", "/recovery", "/forgotMessage", "/forgot/password").permitAll()
                        .antMatchers("/signup", "/logout", "/favicon.ico", "/confirm/**", "/login", "/get").permitAll()
                        .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(failureHandler)
                .and()
                    .logout().deleteCookies("JSESSIONID").logoutUrl("/logout").logoutSuccessUrl("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public Filter googleFilter() {
        GoogleFilter googleFilter = new GoogleFilter("/login/google");
        OAuth2RestTemplate template = new OAuth2RestTemplate(google().getClient(), oauth2ClientContext);
        googleFilter.setRestTemplate(template);
        googleFilter.setUserDao(userDao);
        googleFilter.setRoleDao(roleDao);
        googleFilter.setRuleDao(ruleDao);
        googleFilter.setBCryptPasswordEncoder(bCryptPasswordEncoder);
        return googleFilter;
    }

    @Bean
    public Filter vkFilter() {
        VkFilter vkFilter = new VkFilter("/login/vk");
        OAuth2RestTemplate template = new OAuth2RestTemplate(vk().getClient(), oauth2ClientContext);
        vkFilter.setRestTemplate(template);
        vkFilter.setUserDao(userDao);
        vkFilter.setRoleDao(roleDao);
        vkFilter.setRuleDao(ruleDao);
        vkFilter.setBCryptPasswordEncoder(bCryptPasswordEncoder);
        return vkFilter;
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    @Bean
    @ConfigurationProperties("google")
    public ClientResources google() {
        return new ClientResources();
    }

    @Bean
    @ConfigurationProperties("vk")
    public ClientResources vk() {
        return new ClientResources();
    }

    class ClientResources {

        @NestedConfigurationProperty
        private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();

        @NestedConfigurationProperty
        private ResourceServerProperties resource = new ResourceServerProperties();

        public AuthorizationCodeResourceDetails getClient() {
            return client;
        }

        public ResourceServerProperties getResource() {
            return resource;
        }
    }
}
