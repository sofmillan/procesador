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
    private FileProcessor fileProcessor;
    private int validLines;
    private int invalidLines;

    @Autowired
    public ProcesadorService(LectorFile lectorFile, FileProcessor fileProcessor) {
        this.lectorFile = lectorFile;
        this.fileProcessor = fileProcessor;
    }

    public FileResponse process(File file){
        List<People> peopleList = this.lectorFile.procesar(file);
        for(People person:peopleList){
            boolean validation = fileProcessor.sendLine(person);
            if(validation){
                validLines++;
            }else{
                invalidLines++;
            }
        }

        return new FileResponse(validLines, invalidLines);
    }
}
