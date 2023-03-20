package com.example.procesadorNuevo.service;

import com.example.procesadorNuevo.model.File;
import com.example.procesadorNuevo.model.PeopleXLSX;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileReaderXLSX {
    List<String> listaString ;
    List<PeopleXLSX> listPeople ;

    public FileReaderXLSX(){
        this.listaString = new ArrayList<>();
        this.listPeople  = new ArrayList<>();
    }

    public List<PeopleXLSX> procesar(File file) {
        try {
            FileInputStream f = new FileInputStream(file.getPath());
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(f);
            Iterator<Row> rowIterator = xssfWorkbook.getSheetAt(0).iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    listaString.add(cell.toString());

                }
                PeopleXLSX person = new PeopleXLSX(listaString.get(0), listaString.get(1), listaString.get(2),
                        listaString.get(3), listaString.get(4), listaString.get(5), listaString.get(6), listaString.get(7),
                        listaString.get(8), listaString.get(9), listaString.get(10), listaString.get(11), listaString.get(12),
                        listaString.get(13));
                listPeople.add(person);
                listaString.removeAll(listaString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listPeople;
    }

}
