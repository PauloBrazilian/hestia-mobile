package hestia.ms_security.framework.helper;

import hestia.ms_security.application.service.CustomUserDetailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private CustomUserDetailServiceImpl userDetailsService;
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth2/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth2/register/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/person").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/person/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/person/{id}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/personBus").hasRole("BUSINESS")
                        .requestMatchers(HttpMethod.PUT, "/personBus/{id}").hasRole("BUSINESS")
                        .requestMatchers(HttpMethod.DELETE, "/personBus/{id}").hasRole("BUSINESS")

                        .requestMatchers(HttpMethod.POST, "/products/creating").hasRole("BUSINESS")
                        .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("BUSINESS", "USER")
                        .requestMatchers(HttpMethod.GET, "/products/comparator/{productName}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/products/{productId}").hasAnyRole("BUSINESS", "USER")
                        .requestMatchers(HttpMethod.PUT, "/products/{productId}").hasRole("BUSINESS")
                        .requestMatchers(HttpMethod.DELETE, "/products/{productId}").hasRole("BUSINESS")

                        .requestMatchers(HttpMethod.POST, "/lista").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/lista/all/{personName}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/lista/{listaId}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/lista/comparator/{listaId}").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/lista/{listaId}").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/lista/add/{listaId}/{productId}").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/lista/{listaId}").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/lista/{listaId}/{productId}").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/category").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/category/{categoryName}").hasRole("USER")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}