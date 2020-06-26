package br.edu.logatti.avaliacao2.rabbit.consumer;

import br.edu.logatti.avaliacao2.model.Cargo;
import br.edu.logatti.avaliacao2.service.CargoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CargoConsumer {

    @Autowired
    private CargoService cargoService;

    @RabbitListener(queues = {"${queue.cargo.name}"})
    public void receive(@Payload final Cargo cargo) {
        cargoService.save(cargo);
    }
}
