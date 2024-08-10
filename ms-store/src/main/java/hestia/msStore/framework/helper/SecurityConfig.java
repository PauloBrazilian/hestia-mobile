package hestia.msStore.framework.helper;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
//
//    private JwtAuthenticationEntryPoint authenticationEntryPoint;
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .cors(corsCustomizer -> corsCustomizer.configurationSource(request -> {
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowedOrigins(Collections.singletonList("http://localhost:8081")); // Permitir o frontend se conectar
//                    config.setAllowedMethods(Collections.singletonList("*"));
//                    config.setAllowCredentials(true);
//                    config.setAllowedHeaders(Collections.singletonList("*"));
//                    config.setExposedHeaders(List.of("Authorization"));
//                    config.setMaxAge(3600L);
//                    return config;
//                }))
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()) // Todas as requisições precisam ser autenticadas
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
