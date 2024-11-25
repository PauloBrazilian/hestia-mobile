package prjhestia.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000"); // Domínio do front-end
        config.addAllowedMethod("*"); // Permite todos os métodos (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permite todos os cabeçalhos
        config.setAllowCredentials(true); // Permite cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplica a todas as rotas

        return new CorsWebFilter(source);
    }
}
