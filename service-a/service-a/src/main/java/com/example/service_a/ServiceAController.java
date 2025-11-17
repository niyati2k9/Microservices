package com.example.service_a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/greet")
public class ServiceAController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceAController.class);
    private final RestTemplate restTemplate;

    @Autowired
    public ServiceAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String greet() {
        String response = restTemplate.getForObject("http://service-b:8081/message", String.class);
        logger.info("Received request in Service B - /getMessage endpoint");
        return "Service A says hi! → " + response;
    }
}
