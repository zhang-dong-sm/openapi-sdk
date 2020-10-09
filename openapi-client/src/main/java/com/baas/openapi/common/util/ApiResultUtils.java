package com.baas.openapi.common.util;

import com.baas.openapi.common.config.ApiResult;

import java.util.Collections;
import java.util.List;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
public class ApiResultUtils {

    public static <T> ApiResult<List<T>> convertWithArray(String result, Class<T> tClass) {
        ApiResult<List<T>> apiResult = JsonUtils.fromJson(result, ApiResult.class);
        if (apiResult.getData() == null) {
            apiResult.setData(Collections.emptyList());
        } else {
            String data = JsonUtils.toJson(apiResult.getData());
            List<T> list = JsonUtils.fromJsonArray(data, tClass);
            apiResult.setData(list);
        }
        return apiResult;
    }

    public static <T> ApiResult<T> convert(String result, Class<T> tClass) {
        ApiResult<T> apiResult = JsonUtils.fromJson(result, ApiResult.class);
        if (apiResult.getData() != null) {
            String data = JsonUtils.toJson(apiResult.getData());
            T t = JsonUtils.fromJson(data, tClass);
            apiResult.setData(t);
        }
        return apiResult;
    }
}
