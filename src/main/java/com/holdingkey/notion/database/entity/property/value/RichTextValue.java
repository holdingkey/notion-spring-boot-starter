package com.holdingkey.notion.database.entity.property.value;

import cn.hutool.core.annotation.Alias;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RichTextValue implements IPropertyValue {

    @Alias("rich_text")
    private List<TextValue> richText;

}
