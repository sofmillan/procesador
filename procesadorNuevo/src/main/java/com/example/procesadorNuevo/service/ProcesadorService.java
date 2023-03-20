package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.FileResponse;
import com.example.procesadorNuevo.model.File;
import com.example.procesadorNuevo.model.PeopleCSV;
import com.example.procesadorNuevo.model.PeopleXLSX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcesadorService {
    private FileReaderCSV fileReaderCSV;
   private FileReaderXLSX fileReaderXLSX;
   private FileProcessorCSV processorCSV;
   private FileProcessorXLSX fileProcessorXLSX;
    private int validLines=0;
    private int invalidLines=0;

    @Autowired
    public ProcesadorService(FileReaderCSV fileReaderCSV, FileReaderXLSX fileReaderXLSX,
                             FileProcessorCSV processorCSV, FileProcessorXLSX fileProcessorXLSX) {
        this.fileReaderCSV = fileReaderCSV;
        this.fileReaderXLSX = fileReaderXLSX;
        this.processorCSV = processorCSV;
        this.fileProcessorXLSX = fileProcessorXLSX;
    }

    public FileResponse process(File file){
        if(file.getType().equalsIgnoreCase("csv")){
            List<PeopleCSV> peopleCSVList = this.fileReaderCSV.procesar(file);

            for(PeopleCSV person: peopleCSVList){
               boolean validation = processorCSV.sendLine(person);
                if(validation){
                    validLines++;
                }else{
                    invalidLines++;
                }
            }
        }else if(file.getType().equalsIgnoreCase("xlsx")){
            List<PeopleXLSX> peopleXLSXList = this.fileReaderXLSX.procesar(file);
            for(PeopleXLSX person: peopleXLSXList){
                boolean validation = fileProcessorXLSX.sendLine(person);
                if(validation){
                    validLines++;
                }else{
                    invalidLines++;
                }
            }
        }


        return new FileResponse(validLines, invalidLines);
    }
}
