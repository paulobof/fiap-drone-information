package com.fiap.apiproductor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    public RabbitMQService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }
    public void sendDroneInformation (String queueName, Object message){
        try {
            String messageJson = this.objectMapper.writeValueAsString(message);
            System.out.println("Mensagem publicada na fila: \n");
            System.out.println(messageJson + "\n");
            this.rabbitTemplate.convertAndSend(queueName, messageJson);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

