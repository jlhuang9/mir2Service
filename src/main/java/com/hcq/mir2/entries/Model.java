package com.hcq.mir2.entries;

import lombok.Data;

@Data
public class Model extends BaseEntity {
    /**
     * 服务器名
     */
    private String name;
    /**
     * ip
     */
    private String ip;
    /**
     * 时间
     */
    private String time;
    /**
     * 处理时间
     */
    private Long timeMillis;
    /**
     *线路类别
     */
    private String type;

    /**
     * 详细版本介绍
     */
    private String content;

    /**
     * 客服QQ
     */
    private String qq;

    /**
     * url
     */
    private String src;

}
