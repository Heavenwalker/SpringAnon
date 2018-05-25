package com.nikontem;


import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String[]> configFields = new ArrayList<>();
        List<String[]> dataFields = new ArrayList<>();
        String encryptMethod;
        ReadInput readInput = new ReadInput();

        Anonymizer anonymizer;

        configFields = readInput.specifyConfigFile();
        dataFields = readInput.specifyDataFile();
        encryptMethod = readInput.encryptionType();
        anonymizer = new Anonymizer(configFields, dataFields, encryptMethod);
        anonymizer.Anonymizer();

    }
}
