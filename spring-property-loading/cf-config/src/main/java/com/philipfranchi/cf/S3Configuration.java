package com.philipfranchi.cf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Configuration {

    @Bean
    public SmartCfS3PropertySourceLocator s3PropertySourceLocator() {
        return new SmartCfS3PropertySourceLocator();
    }

}
