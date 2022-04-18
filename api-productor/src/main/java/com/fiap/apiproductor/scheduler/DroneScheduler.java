package com.fiap.apiproductor.scheduler;

import com.fiap.apiproductor.constants.DroneConstants;
import com.fiap.apiproductor.constants.RabbitMQConstants;
import com.fiap.apiproductor.dto.DroneDto;
import com.fiap.apiproductor.service.RabbitMQService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class DroneScheduler {

    private RabbitMQService rabbitMQService;

    public DroneScheduler(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @Scheduled(fixedDelay = 10000)
    public void executar() {
        DroneDto droneDto;
        for (int i = 1; i < DroneConstants.QTY_DRONE + 1; i++) {
            droneDto = new DroneDto(
                    (long) i,
                    randomDouble(-180, 180),
                    randomDouble(-180, 180),
                    randomDouble(10, 40),
                    randomDouble(0, 100),
                    !(new Random().nextInt() % 10 == 0));
//            this.rabbitMQService.sendDroneInformation(RabbitMQConstants.QUEUE_NAME, droneDto);
//           String uri = "http://localhost:8081/drone";
//            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.postForLocation()
        }
    }

    public static double randomDouble(double min, double max) {
        return (new Random().nextDouble() * (max - min)) + min;
    }
}