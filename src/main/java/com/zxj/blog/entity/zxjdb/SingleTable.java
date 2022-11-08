package com.zxj.blog.entity.zxjdb;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SingleTable {
    private Integer id;

    private String key1;

    private Integer key2;

    private String key3;

    private String keyPart1;

    private String keyPart2;

    private String keyPart3;

    private String commonField;
}