package com.nikontem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anonymizer {


    List<String[]> configFields = new ArrayList<>();
    List<String[]> dataFields = new ArrayList<>();
    String encryptMethod;
    ReadInput readInput = new ReadInput();
    Map<String, ArrayList> crossedFields = new HashMap<>();
    CrossFields crossFields;
    EncryptionFactory encryptionFactory;
    AnonymizeData anonymizeData;
    Encryptor encryptor;

    public Anonymizer(List<String[]> configFields, List<String[]> dataFields, String encryptMethod) {
        this.configFields = configFields;
        this.dataFields = dataFields;
        this.encryptMethod = encryptMethod;

    }

    public void Anonymizer() {

        //Get Hashmap Arraylist with sensitive data

        crossFields = new CrossFields(configFields, dataFields);
        crossedFields = crossFields.getCrossedFields();

        //Determine Encrytpion method call the appropriate encrytpion method and get the encrypted values as a hashmap
        encryptionFactory = new EncryptionFactory(encryptMethod, crossedFields);
        encryptor = encryptionFactory.EncryptMethod();

        crossedFields = encryptor.getMap();

        //Merge encrypted data back with plaintext
        anonymizeData = new AnonymizeData(crossedFields, dataFields);
        dataFields = anonymizeData.getCypherFields();


        //Write to file
        try {
            readInput.specifyOutput(dataFields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
