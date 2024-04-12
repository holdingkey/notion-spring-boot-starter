package com.holdingkey.notion.basic.http;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Header {

    private String authorization;

    private String contentType;

    private String notionVersion;

    public Header(String key, String contentType, String notionVersion) {
        this.authorization = "Bearer " + key;
        this.contentType = contentType;
        this.notionVersion = notionVersion;
    }

}
