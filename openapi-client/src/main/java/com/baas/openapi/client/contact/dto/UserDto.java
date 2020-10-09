package com.baas.openapi.client.contact.dto;

import lombok.Data;

/**
 * Create Time:2020/8/28
 * User: luchao
 * Email: luc@shinemo.com
 */
@Data
public class UserDto {

    /**
     * 用户账号
     */
    protected String account;
    /**
     * 用户编码
     */
    protected String code;

    /**
     * 用户名称
     */
    protected String name;

    /**
     * 用户手机号
     */
    protected String mobile;

    /**
     * 用户邮箱
     */
    protected String email;
}
