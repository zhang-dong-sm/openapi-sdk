package com.baas.openapi.client.message.dto;

import lombok.Data;

import java.util.List;

/**
 * 应用消息
 *
 * @Author yhj
 * @Date 2020/9/25
 **/
@Data
public class AppMessageDto {

    /**
     * receivers账号类型 0:uids, 8:登录账号，默认0，第三方应用接收方如果是账号的话，传8
     */
    private int flags;
    /**
     * 必填，消息标题
     */
    private String title;
    /**
     * 必填，消息内容
     */
    private String content;
    /**
     * 必填，消息点击跳转地址(http url格式，默认带免登token)
     */
    private String action;
    /**
     * 必填，接收人列表
     */
    private List<String> receivers;
    /**
     * 必填，发送方ID, 默认是AppId
     */
    private String fromId;
    /**
     * 必填，发送方Name, 默认是AppName
     */
    private String fromName;
    /**
     * 带上此字段，有新消息时，应用上会有红点提示
     */
    private int unreadCount;
}
