package com.baas.openapi.client.login;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.shinemo.baas.openapi.login.client.dto.LoginUserInfoDTO;
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

    public ApiResult<LoginUserInfoDTO> getUserInfoByToken(String ssoToken) {
        try {
            if (StringUtils.isBlank(ssoToken)) {
                return ApiResult.fail("token参数不存在");
            }
            String result = reqWithGetUserInfoByToken(URI + "/oauth2/getUserInfoByToken?token=" + ssoToken);
            return ApiResultUtils.convert(result, LoginUserInfoDTO.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * token 获取用户信息
     *
     * @param url
     * @return
     */
    public String reqWithGetUserInfoByToken(String url) {
        String reqUrl = baseInfo.getUrl(url);
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }
}
