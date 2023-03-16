package com.example.procesadorNuevo.model;

public class File {

    private String path;
    private String type;

    public File(String path, String type) {
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return this.path;
    }

    public String getType() {
        return this.type;
    }
}
