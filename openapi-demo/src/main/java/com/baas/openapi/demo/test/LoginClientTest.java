package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.login.LoginClient;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */

public class LoginClientTest {

    public static void main(String[] args) {
        // 以下配置需要对接相关开发提供
        // http://zct.cc.jl.cegn.cn:21006/
       /* final String openApiUri = "http://zct.cc.jl.cegn.cn:21006/";
        final String appId = "rLaaVD1h";
        final String appSecret = "KKvkx7ZRBylPeaHU";
        final String ssoToken = "eyJtb2JpbGUiOiIxODY5NjI0NTg5NiIsIm9yZ0lkIjoxMDEwNCwic2lnbmF0dXJlIjoiNDk0NjliMTE0NTc2NTgzOGVhNDc4YTMwMzY5NjAwYjYiLCJzaXRlSWQiOjkwMDAsInRpbWVzdGFtcCI6MTYwMzE2NTk0MTU2OSwidWlkIjoiODg4ODkwNzE4NSIsInVzZXJuYW1lIjoiMTg2OTYyNDU4OTYifQ==&from=844b&vit=fps";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        LoginClient loginClient = new LoginClient(baseConfig);
        // 两种方式任选 一个返回json 需要解析， 一个不需要
//        ApiResult<LoginUserInfoDTO> result = loginClient.getUserInfoBySSOToken(ssoToken);
        String result = loginClient.getUserInfoBySSOTokenByJson(ssoToken);
        System.out.printf(result);*/

        // 以下配置需要对接相关开发提供
//        final String openApiUri = "https://36.134.7.227:13001/";
        final String openApiUri="http://101.206.141.219:21006";
        final String appId = "exfDjfUL";
        final String appSecret = "t0nGn3E5HXkcwpxa";
        final String code="WNDRk_OuAsEb_714bsG3LXWFib1-GLuGSEqfThLuqEDNQNntO_OELOKbPVeWlD2qLwMTm7_bCLA0GAZQIWYVhA==";
        //final String ssoToken = "eyJtb2JpbGUiOiIxODY5NjI0NTg5NiIsIm9yZ0lkIjoxMDEwNCwic2lnbmF0dXJlIjoiNDk0NjliMTE0NTc2NTgzOGVhNDc4YTMwMzY5NjAwYjYiLCJzaXRlSWQiOjkwMDAsInRpbWVzdGFtcCI6MTYwMzE2NTk0MTU2OSwidWlkIjoiODg4ODkwNzE4NSIsInVzZXJuYW1lIjoiMTg2OTYyNDU4OTYifQ==&from=844b&vit=fps";
        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);


        LoginClient loginClient = new LoginClient(baseConfig);
        String accessToken=loginClient.getTokenByCodeByJson(code);
        System.out.println(accessToken);
        // 两种方式任选 一个返回json 需要解析， 一个不需要
//        ApiResult<LoginUserInfoDTO> result = loginClient.getUserInfoBySSOToken(ssoToken);
//        String result = loginClient.getUserInfoBySSOTokenByJson(ssoToken);
//        System.out.printf(result);
    }

}
