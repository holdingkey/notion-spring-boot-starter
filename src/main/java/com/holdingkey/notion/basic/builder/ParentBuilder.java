package com.holdingkey.notion.basic.builder;

import com.holdingkey.notion.basic.entity.Parent;

public class ParentBuilder {

    public Parent databaseId(String databaseId) {
        return Parent.builder()
                .type("database_id")
                .databaseId(databaseId).build();
    }

}
