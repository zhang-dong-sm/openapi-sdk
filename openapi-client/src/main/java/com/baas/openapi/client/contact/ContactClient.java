package com.baas.openapi.client.contact;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.contact.dto.OrgDto;

import java.util.List;
import java.util.Map;

/**
 * Create Time:2020/8/31
 * User: luchao
 * Email: luc@shinemo.com
 */
public class ContactClient extends ApiClient {

    /**
     * 通讯录基础URI
     */
    private static final String URI = "openapi-cgw/openapi-contact";

    public ContactClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    /**
     * 拉取通讯录
     *
     * @param orgId
     * @return com.shinemo.baas.openapi.client.common.config.ApiResult
     */
    public ApiResult<List<OrgDto>> pullOfSync(Long orgId) {
        try {
            String result = pullOfSyncByJson(orgId);
            return ApiResultUtils.convertWithArray(result, OrgDto.class);
        } catch (Exception e) {
            LogFactory.error("pullOfSync fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 拉取通讯录
     *
     * @param orgId
     * @return json
     */
    public String pullOfSyncByJson(Long orgId) {
        String pullUri = URI + "/sync/pull";
        String url = baseInfo.getUrl(pullUri);
        if (orgId != null) {
            url = url + "?orgId=" + orgId;
        }
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }


}
