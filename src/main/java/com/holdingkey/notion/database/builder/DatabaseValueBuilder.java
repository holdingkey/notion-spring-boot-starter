package com.holdingkey.notion.database.builder;

import com.holdingkey.notion.basic.builder.ParentBuilder;
import com.holdingkey.notion.basic.entity.Parent;
import com.holdingkey.notion.database.entity.DatabaseValue;
import com.holdingkey.notion.database.entity.property.value.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DatabaseValueBuilder {

    private Parent parent;

    private final Map<String, IPropertyValue> properties;

    public DatabaseValueBuilder() {
        this.properties = new HashMap<>();
    }

    public DatabaseValueBuilder parent(String databaseId) {
        this.parent = new ParentBuilder().databaseId(databaseId);
        return this;
    }

    public DatabaseValueBuilder title(String filed, String content) {
        TitleValue titleValue = TitleValue.builder().title(Collections.singletonList(TextValue.builder().
                type("text").text(TextContentValue.builder().content(content).build()).build())).build();
        this.properties.put(filed, titleValue);
        return this;
    }

    public DatabaseValueBuilder number(String filed, int number) {
        NumberValue numberValue = NumberValue.builder().number(number).build();
        this.properties.put(filed, numberValue);
        return this;
    }

    public DatabaseValueBuilder date(String field, String start) {
        DateValue dateValue = DateValue.builder().date(DateInfoValue.builder().start(start).build()).build();
        this.properties.put(field, dateValue);
        return this;
    }

    public DatabaseValueBuilder richText(String filed, String content) {
        RichTextValue richTextValue = RichTextValue.builder().richText(Collections.singletonList(TextValue.builder().
                type("text").text(TextContentValue.builder().content(content).build()).build())).build();
        this.properties.put(filed, richTextValue);
        return this;
    }

    public DatabaseValueBuilder select(String filed, String name) {
        SelectValue selectValue = SelectValue.builder().select(SelectNameValue.builder().name(name).build()).build();
        this.properties.put(filed, selectValue);
        return this;
    }

    public DatabaseValueBuilder checkbox(String filed, Boolean bool) {
        this.properties.put(filed, new CheckboxValue(bool));
        return this;
    }

    public DatabaseValue build() {
        return DatabaseValue.builder()
                .parent(this.parent)
                .properties(this.properties)
                .build();
    }

}
