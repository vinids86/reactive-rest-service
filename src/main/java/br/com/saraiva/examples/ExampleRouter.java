package br.com.saraiva.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class ExampleRouter {

    @Bean
    public RouterFunction<ServerResponse> routeExample(ExampleHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/example")
                .and(accept(TEXT_PLAIN)), handler::hello);
    }

    @Bean
    public RouterFunction<ServerResponse> routerExampleOneStepFurther(ExampleHandler handler) {
        return RouterFunctions
                .route(GET("/exampleFurther1").and(accept(TEXT_PLAIN)), handler::helloFurther1)
                .andRoute(GET("/exampleFurther2").and(accept(TEXT_PLAIN)), handler::helloFurther2)
                .andRoute(GET("/exampleFurther3").and(accept(TEXT_PLAIN)), handler::helloFurther3);
    }
}
