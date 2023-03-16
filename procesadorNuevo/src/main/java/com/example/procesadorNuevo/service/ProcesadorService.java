package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.FileResponse;
import com.example.procesadorNuevo.model.File;
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

    public FileResponse process(File file){
        List<People> peopleList = this.lectorFile.procesar(file);
        //por cada línea hacer un http request}//e validar hay que tener un post request
        //leer peopleList, registro por registro, enviar cada uno en post request al servicio de validar
        //este servicio retorna true o false (validar)
        //A fileresponse setear las lineas válidas e inválidas
        return new FileResponse();
    }
}
