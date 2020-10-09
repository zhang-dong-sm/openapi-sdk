package com.baas.openapi.client.common.client;

import com.baas.openapi.client.common.config.BaseConfig;

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
