package br.edu.logatti.avaliacao2.rabbit.producer;

import br.edu.logatti.avaliacao2.model.Cargo;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CargoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("cargoQueue")
    @Autowired
    private Queue queue;

    public void send(final Cargo cargo) {
        rabbitTemplate.convertAndSend(queue.getName(), cargo);
    }
}