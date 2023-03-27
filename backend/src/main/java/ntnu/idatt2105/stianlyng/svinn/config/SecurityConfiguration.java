package ntnu.idatt2105.stianlyng.svinn.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  implements WebMvcConfigurer { 
  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

/**
  * Configures the HttpSecurity settings, including access control and authentication.
  *
  * @param http HttpSecurity instance
  * @return SecurityFilterChain instance
  * @throws Exception in case of a failure during configuration
  */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/api/v1/auth/**")
          .permitAll()
        .requestMatchers("/swagger-ui/**")
          .permitAll()
        .requestMatchers("/swagger-ui.html")
          .permitAll()
        .requestMatchers("/v3/api-docs/**")
          .permitAll()
        .requestMatchers("/api/v1/items/**")
          .permitAll()
        .requestMatchers("/api/**") // as a result of teh strict CORS policy in firefox, 
          .permitAll()                          // i had to add this to get the frontend to work
        .anyRequest()                          // everything works fine in postman and qutebrowser 
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }

/**
  * Configures CORS settings for the application.
  *
  * @param registry CorsRegistry instance
  */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
              .allowedOrigins("http://localhost:5173/sell", "http://localhost:5173/") 
              .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
              .allowedHeaders("*")
              .allowCredentials(true);
  }
  
 }