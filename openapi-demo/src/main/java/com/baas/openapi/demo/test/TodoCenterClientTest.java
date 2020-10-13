package com.baas.openapi.demo.test;


import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.todocenter.TodoCenterClient;
import com.baas.openapi.client.todocenter.dto.TodoTaskDto;

import java.util.Arrays;
import java.util.Collections;

public class TodoCenterClientTest {
    private final static String openApiUri = "";
    private final static String appId = "";
    private final static String appSecret = "";
    private final static BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
    private final static TodoCenterClient todoCenterClient = new TodoCenterClient(baseConfig);

    public static void main(String[] args) {
//        pushBatch();
//        finishBatch();
//        revokeBatch();
        sendTaskToHandler();
    }

    private static void sendTaskToHandler() {
        System.out.println(todoCenterClient.sendTaskToHandler("app_task_id_1", Collections.singletonList(8888890571L)));
    }

    public static void pushBatch() {
        TodoTaskDto todoTaskDto = new TodoTaskDto();
        todoTaskDto.setAppTaskId("app_task_id_1");
        todoTaskDto.setTitle("title");
        todoTaskDto.setHandleEntry(Collections.singletonList(
                new TodoTaskDto.HandleEntry(8888890571L, 1)));

        todoTaskDto.setDetailUrl("detailUrl");
        todoTaskDto.setCoverUrl("coverUrl");
        todoTaskDto.setIconUrl("iconUrl");
        todoTaskDto.setSummary("summary");
        todoTaskDto.setSponsorId(111L);
        todoTaskDto.setSponsorUnitId(222L);
        todoTaskDto.setSponsorDepId(333L);
        todoTaskDto.setSponsorTime("2020-09-08 21:00:00");
        todoTaskDto.setBusinessType(1);

        todoTaskDto.setCustomField(Arrays.asList(
                new TodoTaskDto.KeyValEntry("key1", "val1"),
                new TodoTaskDto.KeyValEntry("key2", "val2"),
                new TodoTaskDto.KeyValEntry("key3", "val3")));

        System.out.println(todoCenterClient.pushBatch(Collections.singletonList(todoTaskDto)));
    }

    public static void finishBatch() {
        TodoTaskDto todoTaskDto = new TodoTaskDto();
        todoTaskDto.setAppTaskId("app_task_id_1");
        todoTaskDto.setHandlerIds(Collections.singletonList("8888890571L"));
        System.out.println(todoCenterClient.finishBatch(Collections.singletonList(todoTaskDto)));
    }

    public static void revokeBatch() {
        TodoTaskDto todoTaskDto = new TodoTaskDto();
        todoTaskDto.setAppTaskId("app_task_id_1");
        todoTaskDto.setHandlerIds(Collections.singletonList("8888890571L"));
        System.out.println(todoCenterClient.revokeBatch(Collections.singletonList(todoTaskDto)));
    }
}
