package com.holdingkey.notion.database.entity.property.value;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckboxValue implements IPropertyValue {

    private Boolean checkbox;

}
