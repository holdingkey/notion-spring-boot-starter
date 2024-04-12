package com.holdingkey.notion.database.entity.property.value;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TitleTextValue {

    private String type;

    private TitleTextContentValue text;

}
