package com.nikontem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReadInput {

    private String configFile = ""; //This can only be txt
    private String dataFile = ""; //This can't be txt
    private String outputFile= "";
    private String encryptedFile = ""; // txt or same as "toEncrypt" data file ?
    private String encryptionMethod = "";
    private String fileType;
    private List<String[]> encyptFields;
    private List<String[]> dataFields;
    private TypeCheck typeChecker = new TypeCheck();
    private DocFactory docker = new DocFactory();
    private Printer printer;
    private ParseDoc docparser;
    Scanner scanner = new Scanner(System.in);






    public boolean noFileName(String fileName) {
        if (fileName.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void specifyOutput(List<String[]> cypherFields) throws IOException {
        System.out.println("Specify output file");
        outputFile = scanner.nextLine();
        fileType = typeChecker.getFileExtension(outputFile);
        docker.writeToFile(fileType,outputFile,cypherFields);

    }


    public List<String []> specifyConfigFile() {


        System.out.println("Specify the config file");
        configFile = scanner.nextLine();

        while (noFileName(configFile) || !typeChecker.getFileExtension(configFile).equals("txt")) {
            System.out.println("You did not specify a file name, or it's not in a txt format.");
            configFile = scanner.nextLine();
        }

        docparser = docker.readDocument("config", configFile);
        encyptFields = docparser.getFields();
        return encyptFields;
    }


    public List<String[]> specifyDataFile(){
        System.out.println("Specify the data file");
        dataFile = scanner.nextLine();

        while (noFileName(dataFile)){
            System.out.println("You didn't specify a file name");
            dataFile = scanner.nextLine();
        }
        fileType=typeChecker.getFileExtension(dataFile);
        docparser = docker.readDocument(fileType,dataFile);

        dataFields = docparser.getFields();

        return dataFields;
    }

    public String encryptionType(){

        while(encryptionMethod.equals("")){
            System.out.println("Select encryption method");
            System.out.println("Press 1 for AES");
            int selection = Integer.parseInt(scanner.nextLine());

            switch(selection){
                case 1 :encryptionMethod = "AES";
                break;
                default: encryptionMethod = "";
                break;
            }

        }
        return encryptionMethod;
    }
//
//            if (outputFile.isEmpty()){
//                System.out.println("Specify the output file");
//                outputFile = scanner.nextLine();
//                fileType = typeChecker.getFileExtension(outputFile);
//            }



}


