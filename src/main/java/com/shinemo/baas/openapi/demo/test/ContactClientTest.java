package com.shinemo.baas.openapi.demo.test;


import com.shinemo.baas.openapi.client.common.config.ApiResult;
import com.shinemo.baas.openapi.client.common.config.BaseConfig;
import com.shinemo.baas.openapi.contact.client.ContactClient;
import com.shinemo.baas.openapi.contact.client.dto.DeptDto;
import com.shinemo.baas.openapi.contact.client.dto.OrgDto;
import com.shinemo.baas.openapi.contact.client.dto.UserDto;

import java.util.List;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
public class ContactClientTest {
    private ContactClient contactClient;

    public ContactClientTest(BaseConfig baseConfig) {
        this.contactClient = new ContactClient(baseConfig);
    }

    public static void main(String[] args) {
        // 以下配置需要对接相关开发提供
        final String openApiUri = "http://139.210.243.228:41006/";
        final String appId = "LadymL6A";
        final String appSecret = "Z8VqFV7r2RmH4klI";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        ContactClientTest test = new ContactClientTest(baseConfig);
        test.pullOfSyncByJson(null);
    }

    /**
     * 拉取通讯录
     *
     * @param orgId 非必传 传了则取莫个单位的通讯录
     */
    public void pullOfSync(Long orgId) {
        ApiResult<List<OrgDto>> apiResult = contactClient.pullOfSync(orgId);
        if (apiResult.isSuccess()) {
            List<OrgDto> list = apiResult.getData();
            for (OrgDto orgDto : list) {
                for (DeptDto dept : orgDto.getDepts()) {
                    for (UserDto user : dept.getUsers()) {

                    }
                }
            }
        }
        System.out.println(apiResult.getCode());
    }

    public void pullOfSyncByJson(Long orgId) {
        String json = contactClient.pullOfSyncByJson(orgId);
        System.out.println(json);
    }
}
