package com.shinemo.baas.openapi.demo;

import com.shinemo.baas.openapi.client.client.ContactClient;
import com.shinemo.baas.openapi.client.common.ApiResult;
import com.shinemo.baas.openapi.client.common.BaseConfig;

import javax.swing.*;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
public class Main {

    public static void main(String[] args) {
        // 以下配置需要对接相关开发提供
        final String domin = "http://baas.uban360.net:21006/";
        final String id = "1PsfUjyl";
        final String secret = "Bpf7pQmuuVpxqiO5";

        BaseConfig baseConfig = new BaseConfig(domin, id, secret);
        ContactClient contactClient = new ContactClient(baseConfig);
        ApiResult apiResult = contactClient.pullOfSync(null);
        System.out.println(apiResult.getCode());
    }
}
