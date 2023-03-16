package com.example.procesadorNuevo.controller;

import com.example.procesadorNuevo.FileResponse;
import com.example.procesadorNuevo.service.ProcesadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProcesadorController {

    private ProcesadorService procesadorService;

    @Autowired
    public ProcesadorController(ProcesadorService procesadorService) {
        this.procesadorService = procesadorService;
    }

    @PostMapping("/uploadFile")
    public FileResponse sendPerson(@RequestBody String file){
        return procesadorService.process(file);
    }
}
