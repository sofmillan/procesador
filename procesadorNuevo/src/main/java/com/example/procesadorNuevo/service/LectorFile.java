package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.model.File;
import com.example.procesadorNuevo.model.People;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LectorFile {
    List<People> lines;

    public LectorFile(){
        this.lines = new ArrayList<>();
    }

    public List<People> procesar(File file){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
            String line;
            while((line = br.readLine())!= null){
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                People person = new People(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]);
                lines.add(person);

            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

}
