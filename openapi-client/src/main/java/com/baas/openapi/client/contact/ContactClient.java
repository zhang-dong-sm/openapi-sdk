package com.baas.openapi.client.contact;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.contact.dto.OrgDto;
import com.shinemo.baas.openapi.contact.client.dto.DeptInfoDTO;
import com.shinemo.baas.openapi.contact.client.dto.OrgInfoDTO;

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

    /**
     * 获取单位详情
     *
     * @param orgId
     * @return
     */
    public String getOrgInfo(Long orgId) {
        String pullUri = URI + "/info/getOrgInfo";
        String url = baseInfo.getUrl(pullUri);
        if (orgId != null) {
            url = url + "?orgId=" + orgId;
        }
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }

    /**
     * 获取单位详情
     *
     * @param orgId
     * @param deptId
     * @return
     */
    public String getDeptInfo(Long orgId, Long deptId) {
        String pullUri = URI + "/info/getDeptInfo";
        String url = baseInfo.getUrl(pullUri);
        if (orgId != null && deptId != null) {
            url = url + "?orgId=" + orgId + "&deptId=" + deptId;
        }
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }

    /**
     * 获取用户详情
     * @param orgId
     * @param deptId
     * @param uid
     * @return
     */
    public String getUserInfo(Long orgId, Long deptId, Long uid) {
        String pullUri = URI + "/info/getUserInfo";
        String url = baseInfo.getUrl(pullUri);
        if (orgId != null && deptId != null && uid != null) {
            url = url + "?orgId=" + orgId + "&deptId=" + deptId + "&uid=" + uid;
        }
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }


    /**
     * 获取各级单位详情
     *
     * @param orgId
     * @param flag  1：上级单位 2：下级单位 3：所有上级单位 4：所有下级单位
     * @return
     */
    public ApiResult<List<OrgInfoDTO>> getOrgInfoList(Long orgId, int flag) {
        try {
            String result = getOrgInfoListByJson(orgId, flag);
            return ApiResultUtils.convertWithArray(result, OrgInfoDTO.class);
        } catch (Exception e) {
            LogFactory.error("getOrgInfoList fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 获取各级部门详情
     *
     * @param orgId
     * @param deptId
     * @param flag   1：上级部门 2：下级部门 3：所有上级部门 4：所有下级部门
     * @return
     */
    public ApiResult<List<DeptInfoDTO>>  getDeptInfoList(Long orgId, Long deptId, int flag) {
        try {
            String result = getDeptInfoListByJson(orgId, deptId, flag);
            return ApiResultUtils.convertWithArray(result, DeptInfoDTO.class);
        } catch (Exception e) {
            LogFactory.error("getDeptInfoList fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    public String getOrgInfoListByJson(Long orgId, int flag) {
        String url = baseInfo.getUrl(URI + "/info/getOrgInfoList");
        if (orgId != null) {
            url = url + "?orgId=" + orgId + "&" + "flag=" + flag;
        }
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }

    public String getDeptInfoListByJson(Long orgId, Long deptId, int flag) {
        String url = baseInfo.getUrl(URI + "/info/getDeptInfoList");
        if (orgId != null && deptId != null) {
            url = url + "?orgId=" + orgId + "&" + "?deptId=" + deptId + "&" + "flag=" + flag;
        }
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }
}
