package com.hqw.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "hqw")
public class DqProperties {

    private String name;

    private Integer birth;

    private String country;
}
