package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.model.PeopleCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class FileProcessorCSV {

   // private RestTemplateClient restTemplate;

    private RestTemplate restTemplate;
    @Autowired
    public FileProcessorCSV(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendLine(PeopleCSV person){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PeopleCSV> request = new HttpEntity<>(person, headers);
        boolean response = (Boolean.TRUE.equals(this.restTemplate.postForObject("http://localhost:8080/validator/csv", request, Boolean.class)));
        return response;
    }

}
