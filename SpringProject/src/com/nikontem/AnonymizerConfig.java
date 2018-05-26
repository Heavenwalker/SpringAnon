package com.nikontem;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnonymizerConfig {

    @Bean
    public ReadInput readInput(){
        return new ReadInput();
    }


    @Bean
    public Anonymizer anonymizer(){
        return new Anonymizer(readInput().specifyConfigFile(),readInput().specifyDataFile(),readInput().encryptionType());
    }

}
