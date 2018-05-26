package com.nikontem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Printer {
    private String path;
    private List<String[]> cypherFields = new ArrayList<>();

    public Printer(String path, List<String[]> cypherFields) {
        this.path = path;
        this.cypherFields = cypherFields;
    }


    abstract void writeToFile() throws IOException;


    public String getPath() {
        return path;
    }

    public List<String[]> getCypherFields() {
        return cypherFields;
    }


}
