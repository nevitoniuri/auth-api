package com.nevitoniuri.authapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeConfig -> {
                    authorizeConfig.requestMatchers(HttpMethod.GET, "/users/**").permitAll();
                    authorizeConfig.requestMatchers(HttpMethod.POST, "/users/**").hasAuthority("ADMIN");
                    authorizeConfig.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();
                    authorizeConfig.anyRequest().authenticated();
                })
                .build();
    }

//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedMethods("*");
//    }
}
