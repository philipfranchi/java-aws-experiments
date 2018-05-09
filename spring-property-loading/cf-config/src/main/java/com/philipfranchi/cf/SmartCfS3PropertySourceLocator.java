package com.philipfranchi.cf;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class SmartCfS3PropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {

        Map<String, Object> properties = new HashMap<>();

        boolean lookUpCf =
                environment.containsProperty("cf-lookUp") ?
                        Boolean.parseBoolean(environment.getProperty("cf-lookUp")) :
                        false;

        if(lookUpCf) {
            Map<String, Object> cfProperties = locateCfProperties(environment);
            properties.putAll(cfProperties);
        }

        properties.put("dummy-s3", "s3-value " + environment.getProperty("dummy-cf"));
        MapPropertySource mapPropertySource = new MapPropertySource("s3", properties);
        return mapPropertySource;
    }

    private Map<String, Object> locateCfProperties(Environment environment) {
        CfPropertySourceMapper cfPropertySourceMapper = new CfPropertySourceMapper();
        return cfPropertySourceMapper.createPropertyMap(environment);
    }
}
