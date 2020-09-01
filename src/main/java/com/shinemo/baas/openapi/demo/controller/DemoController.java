package com.shinemo.baas.openapi.demo.controller;

import com.shinemo.baas.openapi.client.client.ContactClient;
import com.shinemo.baas.openapi.client.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private ContactClient contactClient;

    @GetMapping("/test")
    public ApiResult test() {
        ApiResult apiResult = contactClient.pullOfSync(null);
        if (apiResult == null) {
            return ApiResult.fail("fail");
        }
        return apiResult;
    }
}
