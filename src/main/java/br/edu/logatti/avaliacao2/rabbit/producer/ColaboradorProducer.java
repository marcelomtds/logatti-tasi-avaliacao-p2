package br.edu.logatti.avaliacao2.rabbit.producer;

import br.edu.logatti.avaliacao2.model.request.ColaboradorRequest;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ColaboradorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("colaboradorQueue")
    @Autowired
    private Queue queue;

    public void send(final ColaboradorRequest request) {
        rabbitTemplate.convertAndSend(queue.getName(), request);
    }
}