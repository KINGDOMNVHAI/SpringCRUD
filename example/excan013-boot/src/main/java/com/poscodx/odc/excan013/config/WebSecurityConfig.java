package com.poscodx.odc.excan013.config;

import com.poscodx.odc.excan013.config.exceptionhandler.AuthEntryPoint;
import com.poscodx.odc.excan013.config.jwt.AuthTokenFilter;
import com.poscodx.odc.excan013.config.provider.CustomAuthenticationProvider;
import com.poscodx.odc.excan013.config.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthTokenFilter authTokenFilter;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthEntryPoint unauthorizedHandler;
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    // Details omitted for brevity
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authenticationProvider)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        unauthorizedHandler
                )
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                // Our public endpoints
                .antMatchers(HttpMethod.POST, "/author/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/author/signin").permitAll()
                .antMatchers(HttpMethod.POST, "/author/logout").permitAll()
                .antMatchers(HttpMethod.GET, "/images/**").permitAll()
                .antMatchers(HttpMethod.GET, "/files/**").permitAll()
                .antMatchers(HttpMethod.POST, "/utils/**").permitAll()
                .antMatchers(HttpMethod.GET, "/candidate/**").permitAll()
                .antMatchers(HttpMethod.GET, "/code-master/**").permitAll()
                .antMatchers(HttpMethod.GET, "/candidates/export-excel").permitAll()
                .antMatchers("/doing-exam/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .anyRequest().authenticated();
        // Add JWT token filter
        http.addFilterBefore(
                authTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );

    }
}
