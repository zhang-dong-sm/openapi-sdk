package com.baas.openapi.client.common.config;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回对象
 *
 * @author dongzj
 * @date 2020/10/9 10:55
 */
@Data
public class ApiResult<T> implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误内容
     */
    private String msg = "";

    /**
     * 返回对象
     */
    private T data;

    /**
     * 错误返回码
     */
    private int code = 200;

    public static ApiResult instance() {
        return new ApiResult();
    }

    public static ApiResult fail(String msg) {
        return instance().success(false).msg(msg);
    }

    public ApiResult success(boolean isSuccess) {
        this.success = isSuccess;
        return this;
    }

    public ApiResult msg(String msg) {
        this.msg = msg;
        return this;
    }
}
