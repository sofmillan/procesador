package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.config.RestTemplateClient;
import com.example.procesadorNuevo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class FileProcessor {

    private RestTemplateClient restTemplate;

    @Autowired
    public FileProcessor(RestTemplateClient restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendLine(People person){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<People> request = new HttpEntity<>(person, headers);
        boolean response = (this.restTemplate.postForObject("localhost:8080/validator", request, Boolean.class));
        return response;
    }

}
