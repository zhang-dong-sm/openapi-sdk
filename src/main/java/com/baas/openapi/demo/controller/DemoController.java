package com.baas.openapi.demo.controller;

import com.baas.openapi.common.config.ApiResult;
import com.baas.openapi.contact.ContactClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
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
