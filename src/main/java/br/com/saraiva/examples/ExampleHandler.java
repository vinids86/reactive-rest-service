package br.com.saraiva.examples;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
class ExampleHandler {

    Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(fromObject("Hello, Spring Webflux Example!"));
    }

    Mono<ServerResponse> helloFurther1(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(fromObject("Hello, Spring Webflux Example 1!"));
    }

    Mono<ServerResponse> helloFurther2(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(fromObject("Hello, Spring Webflux Example 2!"));
    }

    Mono<ServerResponse> helloFurther3(ServerRequest request) {
        final String name = request.queryParam("name").orElse("");
        return ok().contentType(TEXT_PLAIN)
                .body(fromObject("Hello, " + name + "!"));
    }
}
