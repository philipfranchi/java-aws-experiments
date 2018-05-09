package com.philipfranchi.lambda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MainApp implements ApplicationRunner{

    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.printf("PROPERTY %s\n", environment.getProperty("cf-lookUp"));
        System.out.printf("Property value cf: %s\n",environment.getProperty("dummy-cf"));
        System.out.printf("Property value s3: %s\n",environment.getProperty("dummy-s3"));
    }
}
