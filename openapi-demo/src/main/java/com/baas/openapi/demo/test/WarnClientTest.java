package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.warn.WarnClient;
import com.baas.openapi.client.warn.dto.IsvWarnDto;


public class WarnClientTest {
    private final static String openApiUri = "http://baas.uban360.net:21006/openapi-cgw/baas-index";
    private final static String appId = "56126679";
    private final static String appSecret = "1853e9c856c50012d95f19b9d900a32e";
    private final static BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
    private final static WarnClient warnClient = new WarnClient(baseConfig);

    public static void main(String[] args) {
        saveWarn();
//        triggerWarn();
    }

    public static void saveWarn() {
        IsvWarnDto isvWarnDto = new IsvWarnDto();
        isvWarnDto.setWarnName("第三方预警TEST2");
        isvWarnDto.setWarnDescribe("第三方预警描述12");
        isvWarnDto.setIsvWarnId("111112");
        isvWarnDto.setCreateName("XX公司");
        System.out.println(warnClient.saveWarn(isvWarnDto));
    }

    public static void triggerWarn() {
        IsvWarnDto isvWarnDto = new IsvWarnDto();
        isvWarnDto.setIsvWarnId("111111");
        System.out.println(warnClient.triggerWarn(isvWarnDto));
    }
}
