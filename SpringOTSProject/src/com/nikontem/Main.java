package com.nikontem;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext anonymizing = new AnnotationConfigApplicationContext(AnonymizerConfig.class);

        Anonymizer anonymizer = anonymizing.getBean("anonymizer",Anonymizer.class);

        anonymizer.Anonymizer();

        anonymizing.close();


    }
}
