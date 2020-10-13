package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.permission.PermissionClient;
import com.baas.openapi.client.permission.dto.DevUserDto;

/**
 * 权限demo
 *
 * @author dongzj
 * @date 2020/10/13 15:06
 */
public class PermissionClientTest {

    private final static String openApiUri = "http://baas.uban360.net:21006/openapi-cgw/6Q8ZVoBw";
    private final static String appId = "56126679";
    private final static String appSecret = "1853e9c856c50012d95f19b9d900a32e";
    private final static BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
    private final static PermissionClient permissionClient = new PermissionClient(baseConfig);

    public static void main(String[] args) {
        DevUserDto devUserDto = new DevUserDto();
        devUserDto.setDevId(5717888888L);
        devUserDto.setUid(10104L);
        ApiResult userPermission = permissionClient.getUserPermission(devUserDto);
        System.out.println(userPermission);
    }
}
