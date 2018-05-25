package com.nikontem;

//Call the appropriate parser class based on the file's extension

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocFactory {
    public ParseDoc readDocument(String type, String path){
        ParseDoc parser =null;

        if (type.equals("config")){

            parser = new ParseConfig(path);
            parser.parseFile();
        }

        if(type.equals("txt")){
            parser = new ParseDataTxt(path);
            parser.parseFile();
        }


        return parser;

    }

    public void writeToFile(String type, String path, List<String[]> anonymizedData) throws IOException {
        Printer printer = null;

        if (type.equals("txt")){

            printer = new TxtWriter(path,anonymizedData);
            try {
                printer.writeToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
