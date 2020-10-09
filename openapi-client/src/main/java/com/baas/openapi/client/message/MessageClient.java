package com.baas.openapi.client.message;

import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.JsonUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.message.dto.AppMessageDto;

import java.util.Map;

/**
 * 消息中心client
 */
public class MessageClient extends ApiClient {

    public MessageClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    /**
     * 发送应用消息
     *
     * @param msg 消息结构体
     * @return ApiResult
     */
    public ApiResult pushApp(AppMessageDto msg) {
        try {
            return JsonUtils.fromJson(pushAppBase(msg), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("pushApp fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 发送应用消息
     *
     * @param msg 消息结构体
     * @return string
     */
    public String pushAppBase(AppMessageDto msg) {
        String url = baseInfo.getUrl("message/push/app");
        String paramJson = JsonUtils.toJson(msg);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes().length);
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }
}
