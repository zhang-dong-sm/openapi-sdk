package com.baas.openapi.client.permission;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.JsonUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.permission.dto.DevUserDto;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 权限Client
 *
 * @author dongzj
 * @date 2020/10/13 13:51
 */
public class PermissionClient extends ApiClient {

    /**
     * 权限服务基础路径
     */
    private static final String BASE_URI = "openapi-cgw/dev-permission";

    public PermissionClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    /**
     * 根据人员编码和开发者账号拉取人员权限
     *
     * @param userDto
     * @return
     */
    public ApiResult getUserPermission(DevUserDto userDto) {
        if (!userDto.checkParam()) {
            return ApiResult.fail("参数错误");
        }
        String url = baseInfo.getUrl(BASE_URI + "/getUserPermission");
        String paramJson = JsonUtils.toJson(userDto);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes(StandardCharsets.UTF_8).length);
        String result = OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
        LogFactory.info("getUserPermission - url:{}, param:{}, result:{}", url, paramJson, result);
        return JsonUtils.fromJson(result, ApiResult.class);
    }
}
