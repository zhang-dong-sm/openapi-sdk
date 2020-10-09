package com.baas.openapi.common.client;

import com.baas.openapi.common.config.BaseConfig;

/**
 * @author dongzj
 * @date 2020/10/9 10:52
 */
public class ApiClient {

    protected BaseConfig baseInfo;

    public ApiClient(BaseConfig baseInfo) {
        this.baseInfo = baseInfo;
    }
}
