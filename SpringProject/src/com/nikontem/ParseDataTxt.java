package com.nikontem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseDataTxt extends ParseDoc {
    private String filePath = getPath();
    private File dataFile = new File(filePath);
    private List<String[]> fields = new ArrayList<String[]>();

    private HashMap dict = new HashMap<String, ArrayList<String>>();

    public ParseDataTxt(String path) {
        super(path);
    }

    @Override
    public void parseFile() {

        emptyFile(dataFile);

        try (Scanner newScan = new Scanner(dataFile).useDelimiter("\\t|\\n")) {
            String[] nextLine;
            while (newScan.hasNext()) {
                nextLine = newScan.nextLine().split("\\t");
                fields.add(nextLine);
                // System.out.println("findDelimiter is " + findDelimiter + " at " + fields.size());
            }
            newScan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String[]> getFields() {
        return fields;
    }
}
