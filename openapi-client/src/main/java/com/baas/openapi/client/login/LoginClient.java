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

    /**
     * ssoToken 获取用户信息
     *
     * @param
     * @return 返回结构体
     */
    public ApiResult<LoginUserInfoDTO> getUserInfoBySSOToken(String ssoToken) {
        try {
            if (StringUtils.isBlank(ssoToken)) {
                return ApiResult.fail("ssoToken参数不存在");
            }
            String result = getUserInfoBySSOToken(URI + "/sso/getUserInfoByToken", ssoToken);
            return ApiResultUtils.convert(result, LoginUserInfoDTO.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    private final String err = "{\"success\":false,\"date\":null,\"msg\":\"%s\",\"code\":500}";

    /**
     * ssoToken 获取用户信息
     *
     * @param ssoToken
     * @return 返回json结构
     */
    public String getUserInfoBySSOTokenByJson(String ssoToken) {
        if (StringUtils.isBlank(ssoToken)) {
            return String.format(err, "ssoToken参数不存在");
        }
        return getUserInfoBySSOToken(URI + "/sso/getUserInfoByToken", ssoToken);
    }


    private String getUserInfoBySSOToken(String url, String ssoToken) {
        url = url + "?ssoToken=" + ssoToken;
        String reqUrl = this.baseInfo.getUrl(url);
        Map<String, Object> headers = this.baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(reqUrl, "GET", headers, null, null);
    }
}
