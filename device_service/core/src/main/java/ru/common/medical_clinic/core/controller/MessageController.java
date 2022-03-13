package ru.common.medical_clinic.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.DeviceIdentificationDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MessageController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping(path = "/device")
    public ResponseEntity<?> medicalMessageSend(@RequestBody DeviceIdentificationDto deviceIdentificationDto){
        try {
            String deviceIdentificationDtoJson = objectMapper.writeValueAsString(deviceIdentificationDto);
            amqpTemplate.convertSendAndReceive("medical", deviceIdentificationDtoJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
