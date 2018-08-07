package br.com.saraiva;

import br.com.saraiva.greeting.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        final GreetingWebClient client = new GreetingWebClient();
        System.out.println(client.getResult());
    }
}
