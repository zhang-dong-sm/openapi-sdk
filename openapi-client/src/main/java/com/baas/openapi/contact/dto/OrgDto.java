package com.baas.openapi.contact.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 单位Dto
 *
 * @author dongzj
 * @date 2020/10/9 11:13
 */
@Data
public class OrgDto {

    /**
     * 单位ID
     */
    protected Long id;

    /**
     * 上级单位ID
     */
    protected Long parentId;

    /**
     * 单位名称
     */
    protected String name;

    /**
     * 单位名称
     */
    protected String code;

    /**
     * 部门信息
     */
    protected List<DeptDto> depts = new ArrayList();
}
