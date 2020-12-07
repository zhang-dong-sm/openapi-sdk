package com.baas.openapi.client.warn.dto;

import lombok.Data;

/**
 * @Author yhj
 * @Date 2020/12/2
 **/
@Data
public class IsvWarnDto {
    /**
     * 第三方预警ID（必填，限制200字符）
     */
    private String isvWarnId;

    /**
     * 第三方预警名称（保存时必填，触发预警时非必填，限制50字符）
     */
    private String warnName;

    /**
     * 预警描述（非必填，限制200字符）
     */
    private String warnDescribe;

    /**
     * ISV名称（非必填，限制50字符）
     */
    private String createName;
}
