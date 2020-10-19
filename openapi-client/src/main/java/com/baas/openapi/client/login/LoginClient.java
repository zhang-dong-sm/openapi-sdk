package com.baas.openapi.client.login;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 免登接口Client
 *
 * @author dongzj
 * @date 2020/10/9 19:00
 */
public class LoginClient extends ApiClient {

    private static final String URI = "openapi-cgw/openapi-login";

    public LoginClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    public ApiResult getUserInfoByToken(String ssoToken) {
        try {
            if (StringUtils.isBlank(ssoToken)) {
                return ApiResult.fail("token参数不存在");
            }
            String result = getUserInfoByToken("/oauth2/getUserInfoByToken", ssoToken);
            return ApiResultUtils.convert(result, Map.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * token 获取用户信息
     *
     * @param ssoToken
     * @param reqUri
     * @return
     */
    public String getUserInfoByToken(String ssoToken, String reqUri) {
        String pullUri = URI + reqUri;
        String url = baseInfo.getUrl(pullUri);
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }
}
