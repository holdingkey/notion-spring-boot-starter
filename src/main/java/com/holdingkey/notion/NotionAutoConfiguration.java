package com.holdingkey.notion;

import com.holdingkey.notion.database.DatabaseTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class NotionAutoConfiguration {

    @Resource
    private NotionProperties notionProperties;

    @Bean
    public NotionTemplate notionTemplate() {
        NotionTemplate notionTemplate = new NotionTemplate();
        notionTemplate.setProperties(notionProperties);

        DatabaseTemplate databaseTemplate = new DatabaseTemplate();
        databaseTemplate.setTemplate(notionTemplate);

        notionTemplate.setDatabaseTemplate(databaseTemplate);

        return notionTemplate;
    }

}
