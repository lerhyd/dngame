package com.lerhyd.dngame.config;

import com.google.common.collect.ImmutableList;
import com.lerhyd.dngame.filters.GoogleOauthFilter;
import com.lerhyd.dngame.filters.GoogleRegistrationFilter;
import com.lerhyd.dngame.filters.VkOauthFilter;
import com.lerhyd.dngame.filters.VkRegistrationFilter;
import com.lerhyd.dngame.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.RequestContextFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    private final SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    @Autowired
    @Qualifier("vkRestTemplate")
    private OAuth2RestTemplate vkRestTemplate;

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    @Qualifier("googleRestTemplate")
    public OAuth2RestTemplate googleRestTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();

        http
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(vkOauthFilter(), OAuth2ClientContextFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/vk"));

        http
                .addFilterAfter(new RequestContextFilter(), CsrfFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/vk"));

        http
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(vkRegistrationFilter(), OAuth2ClientContextFilter.class)
                .httpBasic().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/register/vk"));

        http
                .addFilterAfter(new RequestContextFilter(), CsrfFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/register/vk"));

        http
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(googleOauthFilter(), OAuth2ClientContextFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/google"));


        http
                .addFilterAfter(new RequestContextFilter(), CsrfFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/google"));

        http
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(googleRegistrationFilter(), OAuth2ClientContextFilter.class)
                .httpBasic().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/register/google"));

        http
                .addFilterAfter(new RequestContextFilter(), CsrfFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/register/google"));
        http
                .csrf().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/registration", "/users/*").permitAll()
                    .antMatchers("/checkCookies").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                .and()
                    .logout()
                    .deleteCookies("JSESSIONID").logoutSuccessUrl("/logout-success")
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
            .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder)
                .usersByUsernameQuery("select login, password, true from users where login=?")
                .authoritiesByUsernameQuery("select login, role from user_role where login=?");
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(ImmutableList.of("*"));
        corsConfiguration.setAllowedMethods(ImmutableList.of("POST", "GET", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(ImmutableList.of("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public VkOauthFilter vkOauthFilter() {
        VkOauthFilter vkOauthFilter = new VkOauthFilter("/login/vk");
        System.out.println("Vk: " + vkRestTemplate.getResource().getClientId());
        vkOauthFilter.setRestTemplate(vkRestTemplate);
        vkOauthFilter.setAuthService(authService);
        return vkOauthFilter;
    }

    @Bean
    public VkRegistrationFilter vkRegistrationFilter() {
        VkRegistrationFilter vrf = new VkRegistrationFilter("/register/vk");
        vrf.setRestTemplate(vkRestTemplate);
        vrf.setAuthService(authService);
        return vrf;
    }

    @Bean
    public GoogleRegistrationFilter googleRegistrationFilter() {
        GoogleRegistrationFilter filter = new GoogleRegistrationFilter("/register/google");
        filter.setRestTemplate(googleRestTemplate);
        filter.setAuthService(authService);
        return filter;
    }

    @Bean
    public GoogleOauthFilter googleOauthFilter() {
        GoogleOauthFilter googleOauthFilter = new GoogleOauthFilter("/login/google");
        System.out.println("Google: " + googleRestTemplate.getResource().getClientId());
        googleOauthFilter.setRestTemplate(googleRestTemplate);
        googleOauthFilter.setAuthService(authService);
        return googleOauthFilter;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}