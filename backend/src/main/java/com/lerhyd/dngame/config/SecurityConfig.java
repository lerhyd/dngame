package com.lerhyd.dngame.config;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    private final SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

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
                .csrf().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                    .authorizeRequests()
                        .mvcMatchers("/").permitAll()
                        .antMatchers("/**").permitAll()
                        .antMatchers("/", "/main").permitAll()
                        .antMatchers("/registration", "/logout").permitAll()
                        .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(failureHandler)
                .and()
                    .logout().logoutSuccessUrl("/logout-success");
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

}
