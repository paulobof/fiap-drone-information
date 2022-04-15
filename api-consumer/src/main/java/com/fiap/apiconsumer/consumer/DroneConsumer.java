package com.fiap.apiconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.apiconsumer.constants.RabbitMQConstants;
import com.fiap.apiconsumer.dto.DroneDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DroneConsumer {

    @RabbitListener(queues = RabbitMQConstants.QUEUE_NAME)
    private void consumer (String message) throws JsonProcessingException {
        DroneDto droneDto = new ObjectMapper().readValue(message, DroneDto.class);

        System.out.println(droneDto.id);
        System.out.println(droneDto.latitude);
        System.out.println(droneDto.longitude);
        System.out.println(droneDto.longitude);
        System.out.println("------------------------------------");

        throw new IllegalArgumentException("Argumento inválido!");
    }


}
