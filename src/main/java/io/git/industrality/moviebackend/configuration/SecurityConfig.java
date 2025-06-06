package io.git.industrality.moviebackend.configuration;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    AntPathRequestMatcher[] publicEndpoints = List.of(
          new AntPathRequestMatcher("/movie/**"),
          new AntPathRequestMatcher("/movie"))
        .toArray(new AntPathRequestMatcher[0]);

    UrlBasedCorsConfigurationSource source = getCorsConfiguratinSource();

    return http.csrf(CsrfConfigurer::disable)
        .cors((cors) -> cors.configurationSource(source))
        .authorizeHttpRequests(requests -> requests
            .requestMatchers(publicEndpoints).permitAll()
            .anyRequest().authenticated()
        )
        .oauth2ResourceServer(oauth2 -> oauth2
            .jwt(Customizer.withDefaults()))
        .build();
  }

  private static UrlBasedCorsConfigurationSource getCorsConfiguratinSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
