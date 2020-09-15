package com.shinemo.baas.openapi.demo.test;

import com.shinemo.baas.openapi.client.common.config.ApiResult;
import com.shinemo.baas.openapi.client.common.config.BaseConfig;
import com.shinemo.baas.openapi.client.common.util.JsonUtils;
import com.shinemo.baas.openapi.todocenter.client.TodoCenterClient;
import com.shinemo.baas.openapi.todocenter.client.dto.TodoTaskDto;

import java.util.Arrays;
import java.util.Collections;
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
        findByAppTaskId();
//        insertBatchTest();
    }

    public static void findByAppTaskId() {
        List<String> appTaskIds = Arrays.asList("app_task_id_changchun_ioc1", "app_task_id_changchun422", "3");

        final String openApiUri = "http://139.210.243.228:41006/";
        final String appId = "LadymL6A";
        final String appSecret = "Z8VqFV7r2RmH4klI";

//        http://baas.uban360.net:21006/openapi-cgw/baas-todocenter/web/todo-task/findByAppTaskId
//        final String openApiUri = "http://baas.uban360.net:21006/";
//        final String appId = "bE7z18RX";
//        final String appSecret = "4Y2EyZLipfmsSaFR";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        TodoCenterClientTest test = new TodoCenterClientTest(baseConfig);
        System.out.println(JsonUtils.toJson(test.findByAppTaskId(appTaskIds)));
    }

    public ApiResult findByAppTaskId(List<String> appTaskIds) {
        System.out.println(JsonUtils.toJson(appTaskIds));
        return todoCenterClient.findByAppTaskId(appTaskIds);
    }

    public static void insertBatchTest() {
        TodoTaskDto todoTaskDto = new TodoTaskDto();
        todoTaskDto.setAppTaskId("app_task_id_changchun7");
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

        final String openApiUri = "http://139.210.243.228:41006/";
        final String appId = "LadymL6A";
        final String appSecret = "Z8VqFV7r2RmH4klI";

        BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
        TodoCenterClientTest test = new TodoCenterClientTest(baseConfig);
        System.out.println(test.insertBatch(Collections.singletonList(todoTaskDto)));
    }

    public ApiResult insertBatch(List<TodoTaskDto> appTasks) {
        System.out.println(JsonUtils.toJson(appTasks));
        return todoCenterClient.insertBatch(appTasks);
    }
}
