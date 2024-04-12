package com.holdingkey.notion.database.entity.property.value;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TitleValue implements IPropertyValue {

    private List<TitleTextValue> title;

}
