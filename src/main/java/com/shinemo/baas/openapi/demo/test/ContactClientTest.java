package com.shinemo.baas.openapi.demo.test;

import com.shinemo.baas.openapi.client.client.ContactClient;
import com.shinemo.baas.openapi.client.common.ApiResult;
import com.shinemo.baas.openapi.client.common.BaseConfig;

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

    /**
     * 拉取通讯录
     *
     * @param orgId 非必传 传了则取莫个单位的通讯录
     */
    public void pullOfSync(Long orgId) {
        ApiResult apiResult = contactClient.pullOfSync(orgId);
        System.out.println(apiResult.getCode());
    }
}
