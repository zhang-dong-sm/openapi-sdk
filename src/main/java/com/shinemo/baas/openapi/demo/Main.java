package com.shinemo.baas.openapi.demo;

import com.shinemo.baas.openapi.client.common.BaseConfig;
import com.shinemo.baas.openapi.demo.test.ContactClientTest;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
public class Main {

    public static void main(String[] args) {
        // 以下配置需要对接相关开发提供
        final String openApiUri = "http://139.210.243.228:41006/";
        final String appId = "LadymL6A";
        final String appSecret = "Z8VqFV7r2RmH4klI";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        ContactClientTest test = new ContactClientTest(baseConfig);
        test.pullOfSync(null);
    }
}
