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

    public void getOneOrg() {
        String json = contactClient.getOneOrgByJson("121212");
        System.out.println(json);
    }

    public void getOneDept() {
        String json = contactClient.getOneDeptByJson("121212", "33333");
        System.out.println(json);
    }


    public void saveOneOrg() {
        OrgInfoDTO orgInfoDTO = new OrgInfoDTO();
        orgInfoDTO.setParentOrgCode("1605233035228");
        orgInfoDTO.setOrgCode(System.currentTimeMillis() + "");
//        orgInfoDTO.setOrgCode("1605233035228");
        orgInfoDTO.setName("测试" + System.currentTimeMillis());
        String json = contactClient.saveOneOrgByJson(orgInfoDTO);
        System.out.println(json);
    }

    public void saveOneDept() {
        DeptInfoDTO deptInfoDTO = new DeptInfoDTO();
        deptInfoDTO.setName("测试部门1");
        deptInfoDTO.setParentDeptCode("1605233759193");
//        deptInfoDTO.setDeptCode(System.currentTimeMillis() + "");
        deptInfoDTO.setDeptCode("1605233886598");

        deptInfoDTO.setSequence(1);
        deptInfoDTO.setOrgCode("1605233035228");
        deptInfoDTO.setLeaderCode("258963");
        String json = contactClient.saveOneDeptByJson(deptInfoDTO);
        System.out.println(json);
    }

    public void saveOneUser() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setOrgCode("121212");
        userInfoDTO.setDeptCode("33333");
//        String id = "lc" + System.currentTimeMillis();
        String id = "lc1605175756427";
        userInfoDTO.setUserCode(id);
        userInfoDTO.setMobile("1420909" + String.valueOf(System.currentTimeMillis()).substring(9));
        userInfoDTO.setSequence(1);
        userInfoDTO.setName("luchao");
        userInfoDTO.setEmail("luc@foxmail.com");
        Map<String, Object> customField = new HashMap<>();
        customField.put("jobNumberOne", id);
        customField.put("jobNumberTwo", "lc1605175756427c");
        userInfoDTO.setCustomField(customField);
        String json = contactClient.saveOneUserByJson(userInfoDTO);
        System.out.println(json);
    }


}
