package com.holdingkey.notion;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({NotionProperties.class, NotionAutoConfiguration.class})
public @interface EnableNotion {
}
