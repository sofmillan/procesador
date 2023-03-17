package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.config.RestTemplateClient;
import com.example.procesadorNuevo.model.People;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Component
public class FileProcessor {

   // private RestTemplateClient restTemplate;

    private RestTemplate restTemplate;
    @Autowired
    public FileProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendLine(People person){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<People> request = new HttpEntity<>(person, headers);
        boolean response = (Boolean.TRUE.equals(this.restTemplate.postForObject("http://localhost:8080/validator/lines", request, Boolean.class)));
        return response;


    }

}
