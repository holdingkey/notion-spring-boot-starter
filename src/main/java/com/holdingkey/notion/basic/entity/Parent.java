package com.holdingkey.notion.basic.entity;

import cn.hutool.core.annotation.Alias;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Parent {

    private String type;

    @Alias("page_id")
    private String pageId;

    @Alias("database_id")
    private String databaseId;

    private Boolean workspace;

    @Alias("block_id")
    private String blockId;

}
