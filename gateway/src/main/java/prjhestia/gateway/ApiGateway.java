package prjhestia.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateway {


//    private final LoggingFilter loggingFilter;
//
//    @Autowired
//    public ApiGateway(LoggingFilter loggingFilter) {
//        this.loggingFilter = loggingFilter;
//    }
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("msPersons", r -> r.path("/persons/**")
////                        .filters(f -> f.filter(loggingFilter))
//                        .uri("http://localhost:8081"))
//                .route("msStore", r -> r.path("/store/**")
////                        .filters(f -> f.filter(loggingFilter))
//                        .uri("http://localhost:8082"))
//                .build();
//    }

}