package com.holdingkey.notion;

import com.holdingkey.notion.basic.http.Header;
import com.holdingkey.notion.database.DatabaseTemplate;
import lombok.Getter;
import lombok.Setter;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NotionTemplate {

    private static final Logger logger = LoggerFactory.getLogger(NotionTemplate.class);

    @Setter
    @Getter
    private NotionProperties properties;

    @Setter
    private DatabaseTemplate databaseTemplate;

    private OkHttpClient client;

    public OkHttpClient getClient() {
        if (this.client == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            this.client = builder.build();
        }
        return this.client;
    }

    public DatabaseTemplate databaseTemplate() {
        return this.databaseTemplate;
    }

    public String post(String url, String body) {
        try {
            Header header = new Header(this.properties.getToken(), "application/json", this.properties.getNotionVersion());
            MediaType mediaType = MediaType.parse(header.getContentType());
            RequestBody requestBody = RequestBody.create(mediaType, body);
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", header.getAuthorization())
                    .addHeader("Content-Type", header.getContentType())
                    .addHeader("Notion-Version", header.getNotionVersion())
                    .post(requestBody)
                    .build();
            Response response = this.getClient().newCall(request).execute();

            if (Objects.nonNull(response.body())) {
                String result = response.body().string();
                logger.info("请求成功，url：{}，返回数据：{}", url, result);
                return result;
            }
        } catch (Exception e) {
            logger.error("请求失败，url：{}", url, e);
        }
        return "";
    }

}
