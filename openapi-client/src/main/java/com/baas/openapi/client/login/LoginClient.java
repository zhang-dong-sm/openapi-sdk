package com.baas.openapi.client.login;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.common.util.StringUtils;
import com.shinemo.baas.openapi.login.client.dto.LoginUserInfoDTO;
import com.shinemo.baas.openapi.login.client.dto.TokenDTO;

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
            String result = getUserInfoBySSOTokenByJson(ssoToken);
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
        String url = URI + "/sso/getUserInfoByToken?ssoToken=" + ssoToken;
        String reqUrl = this.baseInfo.getUrl(url);
        Map<String, Object> headers = this.baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(reqUrl, "GET", headers, null, null);
    }

    /**
     * 获取AccessToken
     *
     * @param code 授权码(调用授权接口获得的授权码code)
     * @return
     */
    public ApiResult<TokenDTO> getTokenByCode(String code) {
        try {
            if (StringUtils.isBlank(code)) {
                return ApiResult.fail("code参数不存在");
            }
            String result = getTokenByCodeByJson(code);
            return ApiResultUtils.convert(result, TokenDTO.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 获取访问Token
     *
     * @param code 授权码(调用授权接口获得的授权码code)
     * @return
     */
    public String getTokenByCodeByJson(String code) {
        if (StringUtils.isBlank(code)) {
            return String.format(err, "code参数不存在");
        }
        String url = URI + "/oauth2/getTokenByCode?code=" + code;
        String reqUrl = this.baseInfo.getUrl(url);
        Map<String, Object> headers = this.baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(reqUrl, "GET", headers, null, null);
    }

    /**
     * 根据Token获取用户信息
     *
     * @param accessToken 访问token(调用获取token接口获取到的accessToken)
     * @return
     */
    public ApiResult<LoginUserInfoDTO> getUserInfoByAccessToken(String accessToken) {
        try {
            if (StringUtils.isBlank(accessToken)) {
                return ApiResult.fail("accessToken参数不存在");
            }
            String result = getUserInfoByATByJson(accessToken);
            return ApiResultUtils.convert(result, LoginUserInfoDTO.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 根据Token获取用户信息
     *
     * @param accessToken 访问token(调用获取token接口获取到的accessToken)
     * @return
     */
    public String getUserInfoByATByJson(String accessToken) {
        if (StringUtils.isBlank(accessToken)) {
            return String.format(err, "accessToken参数不存在");
        }
        String url = URI + "/oauth2/getUserInfoByToken?accessToken=" + accessToken;
        String reqUrl = this.baseInfo.getUrl(url);
        Map<String, Object> headers = this.baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(reqUrl, "GET", headers, null, null);
    }


    /**
     * 根据refreshToken刷新主平台会话
     *
     * @param refreshToken
     * @return
     */
    public ApiResult<LoginUserInfoDTO> refreshSessionByRT(String refreshToken) {
        try {
            if (StringUtils.isBlank(refreshToken)) {
                return ApiResult.fail("refreshToken参数不存在");
            }
            String result = refreshSessionByRTByJson(refreshToken);
            return ApiResultUtils.convert(result, LoginUserInfoDTO.class);
        } catch (Exception e) {
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 根据refreshToken刷新主平台会话
     *
     * @param refreshToken
     * @return
     */
    public String refreshSessionByRTByJson(String refreshToken) {
        if (StringUtils.isBlank(refreshToken)) {
            return String.format(err, "refreshToken参数不存在");
        }
        String url = URI + "/oauth2/refreshSessionByToken?refreshToken=" + refreshToken;
        String reqUrl = this.baseInfo.getUrl(url);
        Map<String, Object> headers = this.baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(reqUrl, "GET", headers, null, null);
    }
}
