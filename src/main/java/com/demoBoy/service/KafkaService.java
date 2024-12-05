package com.demoBoy.service;

import com.demoBoy.config.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger log = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location){
        this.kafkaTemplate.send(ApplicationConstant.LOCATION_TOPIC_NAME, location);
        this.log.info("Apache Kafka message produced");
        return true;
    }
}
