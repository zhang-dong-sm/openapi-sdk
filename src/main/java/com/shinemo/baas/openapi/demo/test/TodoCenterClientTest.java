package com.shinemo.baas.openapi.demo.test;


import com.shinemo.baas.openapi.client.client.TodoCenterClient;
import com.shinemo.baas.openapi.client.common.ApiResult;
import com.shinemo.baas.openapi.client.common.BaseConfig;
import com.shinemo.baas.openapi.client.util.JsonUtils;
import com.shinemo.baas.todocenter.openapi.TodoTaskDto;

import java.util.List;

/**
 * Create Time:2020/9/1
 * User: luchao
 * Email: luc@shinemo.com
 */
public class TodoCenterClientTest {
    private TodoCenterClient todoCenterClient;

    public TodoCenterClientTest(BaseConfig baseConfig) {
        this.todoCenterClient = new TodoCenterClient(baseConfig);
    }

    public static void main(String[] args) {
        String jsonStr = "[\n" +
                "    {\n" +
                "        \"title\":\"title11\",\n" +
                "        \"detailUrl\":\"detailUrl11\",\n" +
                "        \"coverUrl\":\"coverUrl11\",\n" +
                "        \"iconUrl\":\"iconUrl11\",\n" +
                "        \"summary\":\"summary11\",\n" +
                "        \"customField\":[\n" +
                "            {\n" +
                "                \"key\":\"key11\",\n" +
                "                \"val\":\"val11\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"sponsorId\":11,\n" +
                "        \"sponsorUnitId\":11,\n" +
                "        \"sponsorDepId\":11,\n" +
                "        \"sponsorTime\":\"\",\n" +
                "        \"businessType\":0,\n" +
                "        \"businessStatus\":\"businessStatus11\",\n" +
                "        \"appTaskId\":\"app_task_id_11\",\n" +
                "        \"handleEntry\":[\n" +
                "            {\n" +
                "                \"handlerId\":123,\n" +
                "                \"handleType\":1\n" +
                "            },\n" +
                "            {\n" +
                "                \"handlerId\":456,\n" +
                "                \"handleType\":2\n" +
                "            },\n" +
                "            {\n" +
                "                \"handlerId\":789,\n" +
                "                \"handleType\":1\n" +
                "            }\n" +
                "        ],\n" +
                "        \"handlerIds\":null\n" +
                "    }\n" +
                "]";

        List<TodoTaskDto> appTasks = JsonUtils.fromJsonArray(jsonStr, TodoTaskDto.class);
        System.out.println(appTasks);

        final String openApiUri = "http://baas.uban360.net:21006/";
        final String appId = "myhwGpFR";
        final String appSecret = "xC8wwuTxiz8V1YI3";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        TodoCenterClientTest test = new TodoCenterClientTest(baseConfig);
        System.out.println(test.insertBatch(appTasks));
    }

    public ApiResult insertBatch(List<TodoTaskDto> appTasks) {
        return todoCenterClient.insertBatch(appTasks);
    }
}
