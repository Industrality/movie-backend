package io.git.industrality.moviebackend.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    AntPathRequestMatcher[] publicEndpoints = List.of(
    new AntPathRequestMatcher("/movie/**"),
    new AntPathRequestMatcher("/movie")).toArray(new AntPathRequestMatcher[0]);

    return http
        .csrf(Customizer.withDefaults())
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(publicEndpoints).permitAll()
            .anyRequest().authenticated()
        )
        .build();
  }
}
