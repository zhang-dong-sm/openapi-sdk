package com.baas.openapi.client.message.dto;

import lombok.Data;

import java.util.List;

@Data
public class SmsMessageDto {
    /**
     * 短信内容
     */
    private String content;

    /**
     * 接收人
     */
    private List<String> receivers;
}
