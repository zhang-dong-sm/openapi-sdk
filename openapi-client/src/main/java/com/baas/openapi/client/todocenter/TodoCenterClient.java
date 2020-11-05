package com.baas.openapi.client.todocenter;

import com.baas.openapi.client.common.client.ApiClient;
import com.baas.openapi.client.common.config.ApiResult;
import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.JsonUtils;
import com.baas.openapi.client.common.util.OkHttpUtils;
import com.baas.openapi.client.common.util.StringUtils;
import com.baas.openapi.client.todocenter.dto.TodoTaskDto;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 待办中心Client
 *
 * @author guyuegan
 * @since 2020/9/8
 */
public class TodoCenterClient extends ApiClient {

    /**
     * 待办中心基础URI
     */
    private static final String URI = "openapi-cgw/baas-todocenter";

    public TodoCenterClient(BaseConfig baseInfo) {
        super(baseInfo);
    }

    /**
     * 推送待办任务
     *
     * @param todoTasks 待办任务列表
     * @return com.shinemo.baas.openapi.client.common.config.ApiResult
     */
    public ApiResult pushBatch(List<TodoTaskDto> todoTasks, String accountSource) {
        try {
            return JsonUtils.fromJson(pushBatchBase(todoTasks, accountSource), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("pushBatch fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 推送待办任务
     *
     * @param todoTasks 待办任务列表
     * @return json串
     */
    private String pushBatchBase(List<TodoTaskDto> todoTasks, String accountSource) {
        if (todoTasks == null || todoTasks.isEmpty()) {
            return "To-do task cannot be empty!";
        }

        Map<String, Object> paramMap = new HashMap<>(4);
        // 这里的appId只是占位符，真正的值取自于开发平台透传的appId
        paramMap.put("appId", "Third-Party");
        paramMap.put("appTasks", todoTasks);
        if (StringUtils.isNotBlank(accountSource)) {
            paramMap.put("accountSource", accountSource);
        }

        String url = baseInfo.getUrl(URI + "/web/todo-task/pushBatch");
        String paramJson = JsonUtils.toJson(paramMap);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes(StandardCharsets.UTF_8).length);

        LogFactory.info("paramJson: {}; headers: {}", paramJson, JsonUtils.toJson(headers));
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    /**
     * 根据任务id查询
     *
     * @param appTaskIds 任务id列表
     * @return com.shinemo.baas.openapi.client.common.config.ApiResult
     */
    public ApiResult findByAppTaskId(List<String> appTaskIds) {
        try {
            return JsonUtils.fromJson(findByAppTaskIdBase(appTaskIds), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("findByAppTaskId fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 根据任务id查询
     *
     * @param appTaskIds 任务id列表
     * @return String
     */
    private String findByAppTaskIdBase(List<String> appTaskIds) {
        if (appTaskIds == null || appTaskIds.isEmpty()) {
            return "appTaskIds cannot be empty!";
        }

        String url = baseInfo.getUrl(URI + "/web/todo-task/findByAppTaskId");
        url += appTaskIds.stream()
                .collect(Collectors.joining("&appTaskIds=", "?appTaskIds=", ""));
        Map<String, Object> headers = baseInfo.getHeaders(0);
        return OkHttpUtils.syncHttps(url, "GET", headers, null, "application/x-www-form-urlencoded");
    }

    /**
     * 撤回待办任务
     *
     * @param todoTasks 应用中的待办事项id / 待办事项关联的处理人id列表
     * @return com.shinemo.baas.openapi.client.common.config.ApiResult
     */
    public ApiResult revokeBatch(List<TodoTaskDto> todoTasks, String accountSource) {
        try {
            return JsonUtils.fromJson(revokeBatchBase(todoTasks, accountSource), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("revokeBatch fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 撤回待办任务
     *
     * @param todoTasks 应用中的待办事项id / 待办事项关联的处理人id列表
     * @return String
     */
    private String revokeBatchBase(List<TodoTaskDto> todoTasks, String accountSource) {
        List<TodoTaskDto> okTodoTasks = todoTasks.stream()
                .filter(dto -> StringUtils.isNotBlank(dto.getAppTaskId()))
                .collect(Collectors.toList());
        if (okTodoTasks.isEmpty()) {
            return "todoTasks cannot be empty!";
        }
        Map<String, Object> paramMap = new HashMap<>(4);
        // 这里的appId只是占位符，真正的值取自于开发平台透传的appId
        paramMap.put("appId", "Third-Party");
        paramMap.put("appTasks", okTodoTasks);
        if (StringUtils.isNotBlank(accountSource)) {
            paramMap.put("accountSource", accountSource);
        }

        String url = baseInfo.getUrl(URI + "/web/todo-task/revokeBatch");
        String paramJson = JsonUtils.toJson(paramMap);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes(StandardCharsets.UTF_8).length);

        LogFactory.info("paramJson: {}; headers: {}", paramJson, JsonUtils.toJson(headers));
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    /**
     * 结束待办任务
     *
     * @param todoTasks 应用中的待办事项id / 待办事项关联的处理人id列表
     * @return com.shinemo.baas.openapi.client.common.config.ApiResult
     */
    public ApiResult finishBatch(List<TodoTaskDto> todoTasks, String accountSource) {
        try {
            return JsonUtils.fromJson(finishBatchBase(todoTasks, accountSource), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("finishBatch fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 结束待办任务
     *
     * @param todoTasks 应用中的待办事项id / 待办事项关联的处理人id列表
     * @return String
     */
    private String finishBatchBase(List<TodoTaskDto> todoTasks, String accountSource) {
        List<TodoTaskDto> okTodoTasks = todoTasks.stream()
                .filter(dto -> StringUtils.isNotBlank(dto.getAppTaskId()))
                .collect(Collectors.toList());

        if (okTodoTasks.isEmpty()) {
            return "todoTasks cannot be empty!";
        }

        Map<String, Object> paramMap = new HashMap<>(4);
        // 这里的appId只是占位符，真正的值取自于开发平台透传的appId
        paramMap.put("appId", "Third-Party");
        paramMap.put("appTasks", okTodoTasks);
        if (StringUtils.isNotBlank(accountSource)) {
            paramMap.put("accountSource", accountSource);
        }

        String url = baseInfo.getUrl(URI + "/web/todo-task/finishBatch");
        String paramJson = JsonUtils.toJson(paramMap);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes(StandardCharsets.UTF_8).length);

        LogFactory.info("paramJson: {}; headers: {}", paramJson, JsonUtils.toJson(headers));
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    /**
     * 发送待办任务给处理人
     *
     * @param appTaskId  待办任务id
     * @param handlerIds 处理人id列表
     * @return ApiResult
     */
    public ApiResult sendTaskToHandler(String appTaskId, List<Long> handlerIds) {
        try {
            return JsonUtils.fromJson(sendTaskToHandlerBase(appTaskId, handlerIds), ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("sendTaskToHandler fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }

    /**
     * 发送待办任务给处理人
     *
     * @param appTaskId  待办任务id
     * @param handlerIds 处理人id列表
     * @return String
     */
    private String sendTaskToHandlerBase(String appTaskId, List<Long> handlerIds) {
        if (StringUtils.isBlank(appTaskId)) {
            return "appTaskId cannot be empty!";
        }

        if (handlerIds == null || handlerIds.isEmpty()) {
            return "handlerIds cannot be empty!";
        }

        Map<String, Object> paramMap = new HashMap<>(4);
        // 这里的appId只是占位符，真正的值取自于开发平台透传的appId
        paramMap.put("appId", "Third-Party");
        paramMap.put("appTaskId", appTaskId);
        paramMap.put("handlerIds", handlerIds);

        String url = baseInfo.getUrl(URI + "/web/todo-task/sendTaskToHandler");
        String paramJson = JsonUtils.toJson(paramMap);
        Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes(StandardCharsets.UTF_8).length);

        LogFactory.info("paramJson: {}; headers: {}", paramJson, JsonUtils.toJson(headers));
        return OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
    }

    /**
     * 发送待办任务给处理人
     *
     * @param appTaskId       待办任务id
     * @param handlerAccounts 处理人账号列表
     * @return ApiResult
     */
    public ApiResult sendTaskToHandlerAccount(String appTaskId, List<String> handlerAccounts, String accountSource) {
        try {
            if (StringUtils.isBlank(appTaskId)) {
                return ApiResult.fail("appTaskId cannot be empty!");
            }

            if (handlerAccounts == null || handlerAccounts.isEmpty()) {
                return ApiResult.fail("handlerAccounts cannot be empty!");
            }

            Map<String, Object> paramMap = new HashMap<>(4);
            // 这里的appId只是占位符，真正的值取自于开发平台透传的appId
            paramMap.put("appId", "Third-Party");
            paramMap.put("appTaskId", appTaskId);
            paramMap.put("handlerAccounts", handlerAccounts);
            if (StringUtils.isNotBlank(accountSource)) {
                paramMap.put("accountSource", accountSource);
            }

            String url = baseInfo.getUrl(URI + "/web/todo-task/sendTaskToHandler");
            String paramJson = JsonUtils.toJson(paramMap);
            Map<String, Object> headers = baseInfo.getHeaders(paramJson.getBytes(StandardCharsets.UTF_8).length);

            LogFactory.info("paramJson: {}; headers: {}", paramJson, JsonUtils.toJson(headers));
            String retJson = OkHttpUtils.syncHttps(url, "POST", headers, paramJson, "application/json");
            return JsonUtils.fromJson(retJson, ApiResult.class);
        } catch (Exception e) {
            LogFactory.error("sendTaskToHandlerAccount fail - msg:{},ex:", e.getMessage(), e);
            return ApiResult.fail("请求失败");
        }
    }
}
