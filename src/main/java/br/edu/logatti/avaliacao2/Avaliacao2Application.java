package br.edu.logatti.avaliacao2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Avaliacao2Application {

    @Value("${queue.colaborador.name}")
    private String colaboradorQueue;

    @Value("${queue.cargo.name}")
    private String cargoQueue;

    public static void main(String[] args) {
        SpringApplication.run(Avaliacao2Application.class, args);
        log.info("********** Aplicação iniciada com sucesso **********");
        log.info("Aplicação disponível em: http://localhost:8080");
        log.info("Swagger disponível em: http://localhost:8080/swagger-ui.html");
        log.info("RabbitMQ disponível em: http://localhost:15672");
    }

    @Bean
    public Queue colaboradorQueue() {
        return new Queue(colaboradorQueue, true);
    }

    @Bean
    public Queue cargoQueue() {
        return new Queue(cargoQueue, true);
    }
}
