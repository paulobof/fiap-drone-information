package com.fiap.apiproductor.controller;

import com.fiap.apiproductor.constants.RabbitMQConstants;
import com.fiap.apiproductor.dto.DroneDto;
import com.fiap.apiproductor.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="drone")
public class DroneController {

    @Autowired
    private RabbitMQService rabbitmqService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody DroneDto droneDto){
        this.rabbitmqService.envioMensagem(RabbitMQConstants.QUEUE_NAME, droneDto);
        return new ResponseEntity(HttpStatus.OK);    }
}
