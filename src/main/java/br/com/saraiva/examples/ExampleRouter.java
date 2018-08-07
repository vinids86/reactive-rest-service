package br.com.saraiva.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ExampleRouter {

    @Bean
    public RouterFunction<ServerResponse> routeExample(ExampleHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/example")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }
}
