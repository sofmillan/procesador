package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.FileResponse;
import com.example.procesadorNuevo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcesadorService {

    private LectorFile lectorFile;

    @Autowired
    public ProcesadorService(LectorFile lectorFile) {
        this.lectorFile = lectorFile;
    }

    public FileResponse process(String path){
        List<People> peopleList = this.lectorFile.procesar(path);

        return new FileResponse();
    }
}
