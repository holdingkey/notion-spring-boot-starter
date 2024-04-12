package com.holdingkey.notion.database;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.holdingkey.notion.NotionTemplate;
import com.holdingkey.notion.basic.entity.resp.Result;
import com.holdingkey.notion.basic.http.Uri;
import com.holdingkey.notion.database.entity.DatabaseValue;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class DatabaseTemplate {

    private NotionTemplate template;

    public Boolean adding(DatabaseValue value) {
        String body = JSONUtil.toJsonStr(value);
        String resultStr = this.template.post(getUrl(Uri.PAGES), body);
        if (StrUtil.isBlank(resultStr)) {
            return false;
        }
        Result result = JSONUtil.toBean(resultStr, Result.class);
        return "page".equals(result.getObject());
    }

    private String getUrl(String uri) {
        return this.template.getProperties().getBasicUrl() + uri;
    }

}
