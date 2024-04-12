package com.holdingkey.notion.database.entity;

import com.holdingkey.notion.basic.entity.Parent;
import com.holdingkey.notion.database.entity.property.value.IPropertyValue;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DatabaseValue {

    private Parent parent;

    private Map<String, IPropertyValue> properties;

}
