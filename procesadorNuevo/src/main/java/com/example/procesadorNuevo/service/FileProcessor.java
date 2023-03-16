package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


public class FileProcessor {

    private RestTemplate restTemplate;

    @Autowired
    public FileProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendLine(People person){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<People> request = new HttpEntity<>(person, headers);
        boolean response = (this.restTemplate.postForObject("http://localhost:8080/validator/", request, Boolean.class));
        return response;
    }

}
