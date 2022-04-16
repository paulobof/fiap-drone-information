package com.fiap.apiconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fiap.apiconsumer.constants.RabbitMQConstants;
import com.fiap.apiconsumer.dto.DroneDto;


@Component
public class DroneConsumer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = RabbitMQConstants.QUEUE_NAME)
    private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {

        DroneDto droneDto = objectMapper.readValue(mensagem, DroneDto.class);

        if(droneDto.umidade<=0.15 || droneDto.temperatura<=0 || droneDto.temperatura>=30) {
            System.out.println("Enviar E-mail");
            System.out.println("Umidade: "+droneDto.umidade);
            System.out.println("Temperatura: "+droneDto.temperatura);
        }

    }


}
