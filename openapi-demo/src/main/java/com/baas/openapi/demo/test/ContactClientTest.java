package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.contact.ContactClient;
import com.shinemo.baas.openapi.contact.client.dto.DeptInfoDTO;
import com.shinemo.baas.openapi.contact.client.dto.OrgInfoDTO;
import com.shinemo.baas.openapi.contact.client.dto.UserInfoDTO;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        test.saveOneUser();
    }

    public void saveOrgBase() {
        OrgInfoDTO orgInfoDTO = new OrgInfoDTO();
        orgInfoDTO.setParentCode("0");
        orgInfoDTO.setCode("1212");
        orgInfoDTO.setName("测试3330");
        orgInfoDTO.setAddress("xxxxxx");
        String json = contactClient.saveOrgBase(orgInfoDTO);
        System.out.println(json);
    }

    public void saveDeptBase() {
        DeptInfoDTO deptInfoDTO = new DeptInfoDTO();
        deptInfoDTO.setName("冰山测试部门");
        deptInfoDTO.setParentCode("0");
        deptInfoDTO.setDeptCode("258");
        deptInfoDTO.setSequence(1);
        deptInfoDTO.setOrgCode("12345");
        deptInfoDTO.setLeaderCode("258963");
        String json = contactClient.saveDeptBase(deptInfoDTO);
        System.out.println(json);
    }

    public void saveOneUser() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setOrgCode("121212");
        userInfoDTO.setDeptCode("33333");
        String id = "lc" + System.currentTimeMillis();
        userInfoDTO.setUserCode(id);
        userInfoDTO.setMobile("1420909" + String.valueOf(System.currentTimeMillis()).substring(9));
        userInfoDTO.setSequence(1);
        userInfoDTO.setName("luchao");
        userInfoDTO.setEmail("luc@foxmail.com");
        Map<String, Object> customField = new HashMap<>();
        customField.put("jobNumber1", id);
        userInfoDTO.setCustomField(customField);
        String json = contactClient.saveOneUser(userInfoDTO);
        System.out.println(json);
    }


}
