package br.com.saraiva.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.TEXT_PLAIN;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExampleRouterTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void whenCallExampleFurther1_thenReturnHello() {
        client.get().uri("/exampleFurther1")
                .accept(TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Spring Webflux Example 1!");
    }

    @Test
    public void whenCallExampleFurther2_thenReturnHello() {
        client.get().uri("/exampleFurther2")
                .accept(TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Spring Webflux Example 2!");
    }

    @Test
    public void whenCallExampleFurther3_thenReturnHelloWithName() {
        client.get().uri("/exampleFurther3?name=Sara")
                .accept(TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, Sara!");
    }

    @Test
    public void whenCallAPINotExists_thenReturn404() {
        client.get().uri("/hjksahdjksahd")
                .accept(TEXT_PLAIN)
                .exchange()
                .expectStatus().isNotFound();
    }

}
