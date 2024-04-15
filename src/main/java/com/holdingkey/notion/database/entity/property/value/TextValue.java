package com.holdingkey.notion.database.entity.property.value;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TextValue {

    private String type;

    private TextContentValue text;

}
