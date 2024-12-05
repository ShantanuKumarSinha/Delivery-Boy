package com.demoBoy.Controller;

import com.demoBoy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("deliveryBoy/v1/location")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(String location){
        kafkaService.updateLocation("( "+Math.round(Math.random()*100)+ ","+ +Math.round(Math.random()*100)+" )");
        return  new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }
}
