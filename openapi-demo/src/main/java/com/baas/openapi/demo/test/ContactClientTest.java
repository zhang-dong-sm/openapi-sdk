package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.contact.ContactClient;
import com.baas.openapi.client.contact.dto.DeptDto;
import com.baas.openapi.client.contact.dto.OrgDto;
import com.baas.openapi.client.contact.dto.UserDto;
import com.shinemo.baas.openapi.contact.client.dto.OrgInfoDTO;

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
        //0r3MfoWF
        //jYzTIcQulFNkyGdq
        //10.1.7.5:21006/
        final String openApiUri = "http://baas.uban360.net:21006/";
        final String appId = "ErnIXGv3";
        final String appSecret = "c04IwsEeEjZiFGji";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        ContactClientTest test = new ContactClientTest(baseConfig);
        //test.pullOfSyncByJson(null);
//        test.getOrgInfoByJson(null);
        //test.getUidsByDeptBase(10104L, 10003383L, 4);
        test.saveOrgBase();
    }

    /**
     * 拉取通讯录
     *
     * @param orgId 非必传 传了则取某个单位的通讯录
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

//    public void pullOfSyncByJson(Long orgId) {
//        String json = contactClient.pullOfSyncByJson(orgId);
//        System.out.println(json);
//    }
//
//    public void getOrgInfoByJson(Long orgId) {
//        String json = contactClient.getOrgInfoByJson(orgId);
//        System.out.println(json);
//    }
//
//    public void getDeptInfoByJson(Long orgId, Long deptId) {
//        String json = contactClient.getDeptInfoByJson(orgId, deptId);
//        System.out.println(json);
//    }
//
//    public void getUserInfoByJson(Long orgId, Long deptId, Long uid) {
//        String json = contactClient.getUserInfoByJson(orgId, deptId, uid);
//        System.out.println(json);
//    }
//
//    public void getOrgInfoListByJson(Long orgId, int flag) {
//        String json = contactClient.getOrgInfoListByJson(orgId, flag);
//        System.out.println(json);
//    }
//
//    public void getDeptInfoListByJson(Long orgId, Long deptId, int flag) {
//        String json = contactClient.getDeptInfoListByJson(orgId, deptId, flag);
//        System.out.println(json);
//    }
//
//    public void getThirdUserInfo(Long uid) {
//        String json = contactClient.getThirdUserInfo(uid);
//        System.out.println(json);
//    }
//
//    public void getUidsByRoleBase(String roleCode, Long devId) {
//        String json = contactClient.getUidsByRoleBase(roleCode, devId);
//        System.out.println(json);
//    }
//
//    public void getUidsByDeptBase(Long orgId, Long deptId, int flag) {
//        String json = contactClient.getUidsByDeptBase(orgId, deptId, flag);
//        System.out.println(json);
//    }
//
//    public void getOrgTreeBase(Long orgId) {
//        String json = contactClient.getOrgTreeBase(orgId);
//        System.out.println(json);
//    }
//
//    public void getDeptTreeBase(Long orgId, Long deptId) {
//        String json = contactClient.getDeptTreeBase(orgId, deptId);
//        System.out.println(json);
//    }

    public void saveOrgBase() {
        OrgInfoDTO orgInfoDTO = new OrgInfoDTO();
        orgInfoDTO.setParentId(0L);
        orgInfoDTO.setCode("123");
        orgInfoDTO.setName("测试3330");
        orgInfoDTO.setAddress("xxxxxx");
        String json = contactClient.saveOrgBase(orgInfoDTO);
        System.out.println(json);
    }


}
