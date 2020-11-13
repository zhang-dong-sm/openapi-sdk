package com.baas.openapi.client.sms;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.util.JsonUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;

import java.util.Map;

/**
 * @author: lhw *
 * @Date: 2020/10/10 17:57 *
 * @Description:
 */
public class SmsClient extends ApiClient {
    /**
     * 发短信连接
     */
    private static final String URI = "openapi-cgw/openapi-sms";

    public SmsClient(BaseConfig baseInfo) {
        super(baseInfo);
    }


    /**
     * @param mobile  手机号 多个手机号用逗号隔开
     * @param content 信息内容
     * @return
     */
    public ApiResult sendSms(String mobile, String content) {
        if (mobile == null || "".equals(mobile)) {
            return ApiResult.fail("请输入手机号");
        }
        String pullUri = URI + "/sms/sendsms?mobile=" + mobile + "&content=" + content;
        Map<String, Object> headers = baseInfo.getHeaders(0);
        String result = OkHttpUtils.syncHttps(pullUri, "GET", headers, null, null);
        return JsonUtils.fromJson(result, ApiResult.class);
    }

}
