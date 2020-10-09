package com.baas.openapi.client.sso;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;

import java.util.Map;

/**
 * 免登接口Client
 *
 * @author dongzj
 * @date 2020/10/9 19:00
 */
public class SsoClient extends ApiClient {

    /**
     * 单点登录基础URI
     */
    private static final String URI = "openapi-cgw/baas-sso";

    public SsoClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    public ApiResult login(String token) {
        try {
            String result = loginByToken("/login", token);
            return ApiResultUtils.convert(result, Map.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    public ApiResult hwlogin(String ssoTicket) {
        try {
            String result = loginByToken("/hwlogin", ssoTicket);
            return ApiResultUtils.convert(result, Map.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    private String loginByToken(String url, String token) {
        String loginUrl = URI + url;
        url = baseInfo.getUrl(loginUrl);
        url = url + "?token=" + token;
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }
}
