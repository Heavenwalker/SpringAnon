package com.nikontem;

import java.io.File;
import java.util.List;
import java.util.Scanner;


public abstract class ParseDoc {

    private String path;


    public ParseDoc(String path) {
        this.path = path;
    }


    public void emptyFile(File check) {
        if (check.length() == 0) {
            Scanner newScan = new Scanner(System.in);

            String newPath;
            while (check.length() == 0) {
                check = null;
                System.out.println("The file you specified appears to be empty. Please specify another file");
                newPath = newScan.nextLine();
                check = new File(newPath);
            }
        }
    }
    abstract void parseFile();

    abstract List<String []> getFields();

    public String getPath() {
        return path;
    }
}

