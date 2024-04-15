package com.holdingkey.notion.database.entity.property.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class NumberValue implements IPropertyValue {

    private int number;

}
