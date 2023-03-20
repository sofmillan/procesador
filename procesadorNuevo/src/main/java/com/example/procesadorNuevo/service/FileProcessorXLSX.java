package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.model.PeopleXLSX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FileProcessorXLSX {
    private RestTemplate restTemplate;
    @Autowired
    public FileProcessorXLSX(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendLine(PeopleXLSX person){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PeopleXLSX> request = new HttpEntity<>(person, headers);
        boolean response = (Boolean.TRUE.equals(this.restTemplate.postForObject("http://localhost:8080/validator/xlsx", request, Boolean.class)));
        return response;
    }
}
