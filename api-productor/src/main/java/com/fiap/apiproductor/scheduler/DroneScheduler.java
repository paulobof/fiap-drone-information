package com.fiap.apiproductor.scheduler;

import com.fiap.apiproductor.constants.Constants;
import com.fiap.apiproductor.dto.DroneDto;
import com.fiap.apiproductor.service.RabbitMQService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@Component
public class DroneScheduler {

    private RabbitMQService rabbitMQService;

    public DroneScheduler(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @Scheduled(fixedDelay = 10000)
    public void executar() {
        DroneDto droneDto;
        for (int i = 1; i < Constants.QTY_DRONE+1; i++) {
            droneDto = new DroneDto(
                    (long) i,
                    randomDouble(-180,180),
                    randomDouble(-180,180),
                    randomDouble(0,50),
                    randomDouble(0,100),
                    !(nextInt() % 10 == 0));
            this.rabbitMQService.sendDroneInformation(Constants.QUEUE_NAME, droneDto);
        }
    }

    public static double randomDouble(double min, double max) {
        return (new Random().nextDouble() * (max - min)) + min;
    }
}