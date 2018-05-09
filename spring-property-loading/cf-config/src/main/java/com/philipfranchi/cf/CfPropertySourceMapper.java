package com.philipfranchi.cf;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class CfPropertySourceMapper{

    public Map<String, Object> createPropertyMap(Environment environment) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("dummy-cf", "cf-value");
        return properties;
    }
}
