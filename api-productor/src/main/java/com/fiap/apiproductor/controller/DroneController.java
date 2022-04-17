package com.fiap.apiproductor.controller;

import com.fiap.apiproductor.constants.RabbitMQConstants;
import com.fiap.apiproductor.dto.DroneDto;
import com.fiap.apiproductor.service.RabbitMQService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="drone")
public class DroneController {

    private RabbitMQService rabbitMQService;

    public DroneController(RabbitMQService rabbitMQService){
        this.rabbitMQService = rabbitMQService;
    }

    @PutMapping
    private ResponseEntity sendDroneInformation(@RequestBody DroneDto droneDto){
        this.rabbitMQService.sendDroneInformation(RabbitMQConstants.QUEUE_NAME, droneDto);
        return new ResponseEntity(HttpStatus.OK);    }
}
