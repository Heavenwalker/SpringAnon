package com.nikontem;

// Check if file does exits and determine its' data type

import java.io.File;

public class TypeCheck {
    private String fileType;



    public  String getFileExtension(String fullName) {

        File fileName = new File(fullName);



//        if (!fileName.exists() || fileName.isDirectory()){
//                System.out.println("File does not exist");
//        }

        if (fullName != null && !fullName.isEmpty()){
            int dotIndex = fullName.lastIndexOf('.');
            fileType = (dotIndex == -1) ? "" : fullName.substring(dotIndex + 1);
        } else {

            System.out.println("No file specified exiting...");
            System.exit(0);
        }
        return fileType;

    }


}
