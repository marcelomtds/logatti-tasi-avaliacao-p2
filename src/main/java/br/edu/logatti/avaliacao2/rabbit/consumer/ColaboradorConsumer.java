package br.edu.logatti.avaliacao2.rabbit.consumer;

import br.edu.logatti.avaliacao2.model.request.ColaboradorRequest;
import br.edu.logatti.avaliacao2.service.ColaboradorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ColaboradorConsumer {

    @Autowired
    private ColaboradorService colaboradorService;

    @RabbitListener(queues = {"${queue.colaborador.name}"})
    public void receive(@Payload final ColaboradorRequest request) {
        colaboradorService.save(request);
    }
}