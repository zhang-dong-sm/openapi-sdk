package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.contact.ContactClient;
import com.baas.openapi.client.contact.dto.DeptDto;
import com.baas.openapi.client.contact.dto.OrgDto;
import com.baas.openapi.client.contact.dto.UserDto;
import com.baas.openapi.client.login.LoginClient;
import com.shinemo.baas.openapi.login.client.dto.LoginUserInfoDTO;

import java.util.List;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
public class LoginClientTest {

    public static void main(String[] args) {
        // 以下配置需要对接相关开发提供
        // http://zct.cc.jl.cegn.cn:21006/
        final String openApiUri = "http://zct.cc.jl.cegn.cn:21006/";
        final String appId = "rLaaVD1h";
        final String appSecret = "KKvkx7ZRBylPeaHU";
        final String ssoToken = "eyJtb2JpbGUiOiIxODY5NjI0NTg5NiIsIm9yZ0lkIjoxMDEwNCwic2lnbmF0dXJlIjoiNDk0NjliMTE0NTc2NTgzOGVhNDc4YTMwMzY5NjAwYjYiLCJzaXRlSWQiOjkwMDAsInRpbWVzdGFtcCI6MTYwMzE2NTk0MTU2OSwidWlkIjoiODg4ODkwNzE4NSIsInVzZXJuYW1lIjoiMTg2OTYyNDU4OTYifQ==&from=844b&vit=fps";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        LoginClient loginClient = new LoginClient(baseConfig);
        // 两种方式任选 一个返回json 需要解析， 一个不需要
//        ApiResult<LoginUserInfoDTO> result = loginClient.getUserInfoBySSOToken(ssoToken);
        String result = loginClient.getUserInfoBySSOTokenByJson(ssoToken);
        System.out.printf(result);
    }

}
