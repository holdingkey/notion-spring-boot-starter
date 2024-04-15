package com.holdingkey.notion.database.entity.property.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DateValue implements IPropertyValue {

    private DateInfoValue date;

}
