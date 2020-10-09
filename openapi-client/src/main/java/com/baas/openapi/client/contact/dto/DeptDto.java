package com.baas.openapi.client.contact.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Create Time:2020/8/28
 * User: luchao
 * Email: luc@shinemo.com
 */
@Data
public class DeptDto {

    /**
     * 部门ID
     */
    protected Long id;

    /**
     * 上级部门ID
     */
    protected Long parentId;

    /**
     * 部门名称
     */
    protected String name;

    /**
     * 部门编码
     */
    protected String code;

    /**
     * 部门排序
     */
    protected Integer sequence;

    /**
     * 部门用户
     */
    protected List<UserDto> users = new ArrayList<>();
}
