package com.nikontem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class ParseConfig extends ParseDoc {
    public ParseConfig(String path) {
        super(path);
    }

    private String filePath = getPath();
    private File configFile = new File(filePath);
    private List<String[]> fields = new ArrayList<String[]>();
    private StringBuilder tempFields = new StringBuilder();



    @Override
    public void parseFile() {

        emptyFile(configFile);

        try (Scanner newScan = new Scanner(configFile)) {

            while(newScan.hasNextLine()){
               tempFields.append(newScan.next() + "\t");

            }
            fields.add(tempFields.toString().split("\\t"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




//        for (String[] conf : fields){
//            System.out.println(Arrays.toString(conf));
//        }

    }

    @Override
    public List< String[] > getFields() {
        return fields;
    }

}

