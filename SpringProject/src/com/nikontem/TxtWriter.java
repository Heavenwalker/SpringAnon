package com.nikontem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;

public class TxtWriter extends Printer {
    private FileWriter writer;

    public TxtWriter(String path, List<String[]> cypherFields) {
        super(path, cypherFields);
    }

    @Override
    void writeToFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.getPath()));

        for (String[] str : getCypherFields()) {

            for (String s : str) {

                bw.write(s + "\t");

            }

            bw.newLine();
        }
        bw.close();
    }
}
