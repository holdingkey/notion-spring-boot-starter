package com.holdingkey.notion;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "notion")
public class NotionProperties {

    private Integer readTimeout = 100;

    private Integer connectTimeout = 60;

    private Integer writeTimeout = 60;

    private String basicUrl;

    private String token;

    private String notionVersion;

}
