package com.fiap.apiconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.apiconsumer.constants.MailConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fiap.apiconsumer.constants.RabbitMQConstants;
import com.fiap.apiconsumer.dto.DroneDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class DroneConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    public StringBuilder stringBuilder = new StringBuilder();

    @RabbitListener(queues = RabbitMQConstants.QUEUE_NAME)
    private void consumidor(String mensagem) {
        DroneDto droneDto = null;
        try {
            droneDto = objectMapper.readValue(mensagem, DroneDto.class);
            System.out.println("Mensagem lida da fila: \n");
            System.out.println(mensagem + "\n");
            if (droneDto != null &&
                    (droneDto.getUmidade() <= 0.15) || (droneDto.getTemperatura() <= 0 || droneDto.getTemperatura() >= 35)) {
                System.out.println("Leitura dentro dos critérios, adicionar ao alerta!\n");
                stringBuilder.append("----------------------------------------------").append(MailConstants.BR)
                        .append("DRONE ID: ").append(droneDto.getId()).append(MailConstants.BR)
                        .append("LATITUDE: ").append((double) (Math.round(droneDto.getLatitude() * 100000)) / 100000).append(MailConstants.BR)
                        .append("LONGITUDE: ").append((double) (Math.round(droneDto.getLongitude() * 100000)) / 100000).append(MailConstants.BR)
                        .append("TEMPERATURA: ").append((double) (Math.round(droneDto.getTemperatura() * 100)) / 100).append("ºC").append(MailConstants.BR)
                        .append("UMIDADE: ").append((double) (Math.round(droneDto.getUmidade() * 100)) / 100).append("%").append(MailConstants.BR)
                        .append("RASTREAMENTO: ").append((droneDto.isRastreamento() ? "Ativado" : "Desativado")).append(MailConstants.BR)
                        .append("HORARIO DA LEITURA: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))).append(MailConstants.BR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
