package com.baas.openapi.client.warn;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.JsonUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.warn.dto.IsvWarnDto;

import java.util.Map;

/**
 * @Author yhj
 * @Date 2020/12/4
 **/
public class WarnClient  extends ApiClient {
    public WarnClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    /**
     * 保存预警信息
     *
     * @param isvWarnDto 预警消息结构体
     * @return ApiResult
     */
    public ApiResult saveWarn(IsvWarnDto isvWarnDto) {
        try {
            return JsonUtils.fromJson(saveWarnBase(isvWarnDto), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("saveWarn fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 触发预警
     * @param isvWarnDto 预警消息结构体
     * @return ApiResult
     */
    public ApiResult triggerWarn(IsvWarnDto isvWarnDto) {
        try {
            return JsonUtils.fromJson(triggerWarnBase(isvWarnDto), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("triggerWarn fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    private String saveWarnBase(IsvWarnDto isvWarnDto) {
        String url = baseInfo.getUrl("open/warn/api/save");
        String paramJson = JsonUtils.toJson(isvWarnDto);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes().length);
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    private String triggerWarnBase(IsvWarnDto isvWarnDto) {
        String url = baseInfo.getUrl("open/warn/api/trigger");
        String paramJson = JsonUtils.toJson(isvWarnDto);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes().length);
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }
}
