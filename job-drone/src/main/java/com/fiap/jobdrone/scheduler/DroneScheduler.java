package com.fiap.jobdrone.scheduler;

import com.fiap.jobdrone.dto.DroneDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class DroneScheduler {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${drone}")
    private Long idDrone;

    String uri = "http://localhost:8081/drone";

    @Scheduled(fixedDelay = 10000)
    public void executar() {
        System.out.println("Iniciando leitura... \n");
        DroneDto droneDto;
            droneDto = new DroneDto(
                    idDrone,
                    randomDouble(-180, 180),
                    randomDouble(-180, 180),
                    randomDouble(10, 40),
                    randomDouble(0, 100),
                    !(new Random().nextInt() % 10 == 0));


            try {
                System.out.println(droneDto);
                System.out.println("Enviando leitura para api\n");
                restTemplate.postForLocation(uri, droneDto);
            } catch (Exception e) {
                e.getMessage();
            }
    }

    private double randomDouble(double min, double max) {
        return (new Random().nextDouble() * (max - min)) + min;
    }
}