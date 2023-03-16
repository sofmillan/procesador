package com.example.procesadorNuevo;

public class FileResponse {
    private int validLines;
    private int invalidLines;

    public FileResponse(){}

    public FileResponse(int validLines, int invalidLines) {
        this.validLines = validLines;
        this.invalidLines = invalidLines;
    }

    public void setValidLines(int validLines) {
        this.validLines = validLines;
    }

    public void setIinvalidLines(int iinvalidLines) {
        this.invalidLines = iinvalidLines;
    }

    public int getValidLines() {
        return validLines;
    }

    public int getIinvalidLines() {
        return invalidLines;
    }
}
