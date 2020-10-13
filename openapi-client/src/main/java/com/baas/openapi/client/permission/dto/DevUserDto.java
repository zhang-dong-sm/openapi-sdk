package com.baas.openapi.client.permission.dto;

import lombok.Data;

/**
 * 人员Dto
 * @author dongzj
 * @date 2020/10/13 13:52
 */
@Data
public class DevUserDto {

    /**
     * 开发者账号编码
     */
    private Long devId;

    /**
     * 用户编码
     */
    private Long uid;

    /**
     * 参数校验
     *
     * @return
     */
    public boolean checkParam() {
        if (null == devId || null == uid) {
            return false;
        }
        return true;
    }
}
