package com.baas.openapi.client.contact;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiException;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.ApiResultUtils;
import com.baas.openapi.client.common.util.JsonUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.common.util.StringUtils;
import com.shinemo.baas.openapi.contact.client.dto.DeptInfoDTO;
import com.shinemo.baas.openapi.contact.client.dto.OrgDto;
import com.shinemo.baas.openapi.contact.client.dto.OrgInfoDTO;
import com.shinemo.baas.openapi.contact.client.dto.UserInfoDTO;

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
     * @param orgCode 单位编码
     * @return
     */
    public ApiResult<OrgInfoDTO> getOneOrg(String orgCode) {
        try {
            String result = getOneOrgByJson(orgCode);
            return ApiResultUtils.convert(result, OrgInfoDTO.class);
        } catch (Exception e) {
            LogFactory.error("getOrgInfo fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 获取单位详情
     *
     * @param orgCode 单位编码
     * @return
     */
    public String getOneOrgByJson(String orgCode) {
        String url = baseInfo.getUrl(URI + "/org/getOne");
        if (StringUtils.isBlank(orgCode)) {
            throw new ApiException("单位编码不能为空");
        }
        url = url + "?orgCode=" + orgCode;
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }

    /**
     * 获取部门详情
     *
     * @param orgCode  单位编码
     * @param deptCode 部门编码
     * @return
     */
    public ApiResult<DeptInfoDTO> getOneDept(String orgCode, String deptCode) {
        try {
            String result = getOneDeptByJson(orgCode, deptCode);
            return ApiResultUtils.convert(result, DeptInfoDTO.class);
        } catch (Exception e) {
            LogFactory.error("getDeptInfo fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 获取部门详情
     *
     * @param orgCode  单位编码
     * @param deptCode 部门编码
     * @return
     */
    public String getOneDeptByJson(String orgCode, String deptCode) {
        String url = baseInfo.getUrl(URI + "/dept/getOne");
        if (StringUtils.isBlank(orgCode)) {
            throw new ApiException("单位编码不能为空");
        }
        if (StringUtils.isBlank(deptCode)) {
            throw new ApiException("部门编码不能为空");
        }
        url = url + "?orgCode=" + orgCode + "&deptCode=" + deptCode;
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }

    /**
     * 获取用户详情
     *
     * @param orgCode  单位编码
     * @param deptCode 部门编码
     * @param userCode 员工编码
     * @return
     */
    public ApiResult<UserInfoDTO> getOneUser(String orgCode, String deptCode, String userCode) {
        try {
            String result = getOneUserByJson(orgCode, deptCode, userCode);
            return ApiResultUtils.convert(result, UserInfoDTO.class);
        } catch (Exception e) {
            LogFactory.error("getUserInfo fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 获取用户详情
     *
     * @param orgCode  单位编码
     * @param deptCode 部门编码
     * @param userCode 员工编码
     * @return
     */
    public String getOneUserByJson(String orgCode, String deptCode, String userCode) {
        String url = baseInfo.getUrl(URI + "/user/getOne");
        if (StringUtils.isBlank(orgCode)) {
            throw new ApiException("单位编码不能为空");
        }
        if (StringUtils.isBlank(deptCode)) {
            throw new ApiException("部门编码不能为空");
        }
        if (StringUtils.isBlank(userCode)) {
            throw new ApiException("员工编码不能为空");
        }
        url = url + "?orgCode=" + orgCode + "&deptCode=" + deptCode + "&userCode=" + userCode;
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, null);
    }

    public ApiResult saveOneOrg(OrgInfoDTO orgInfoDTO) {
        try {
            return JsonUtils.fromJson(saveOneOrgByJson(orgInfoDTO), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("saveOrg fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    public String saveOneOrgByJson(OrgInfoDTO orgInfoDTO) {
        String url = baseInfo.getUrl(URI + "/org/saveOne");
        String paramJson = JsonUtils.toJson(orgInfoDTO);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes().length);
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    public ApiResult saveOneDept(DeptInfoDTO deptInfoDTO) {
        try {
            return JsonUtils.fromJson(saveOneDeptByJson(deptInfoDTO), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("saveOrg fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    public String saveOneDeptByJson(DeptInfoDTO deptInfoDTO) {
        String url = baseInfo.getUrl(URI + "/dept/saveOne");
        String paramJson = JsonUtils.toJson(deptInfoDTO);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes().length);
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    public ApiResult saveOneUser(UserInfoDTO userInfoDTO) {
        try {
            return JsonUtils.fromJson(saveOneUserByJson(userInfoDTO), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("saveOrg fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    public String saveOneUserByJson(UserInfoDTO userInfoDTO) {
        String url = baseInfo.getUrl(URI + "/user/saveOne");
        String paramJson = JsonUtils.toJson(userInfoDTO);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes().length);
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }
}
