package com.baas.openapi.demo.test;

import com.baas.openapi.client.common.config.BaseConfig;
import com.baas.openapi.client.message.MessageClient;
import com.baas.openapi.client.message.dto.AppMessageDto;

import java.util.ArrayList;
import java.util.List;

public class MessageClientTest {
    private final static String appName = "测试消息中心";
    private final static String openApiUri = "http://baas.uban360.net:21006/openapi-cgw/J1HB1XG7";
    private final static String appId = "56126679";
    private final static String appSecret = "1853e9c856c50012d95f19b9d900a32e";
    private final static BaseConfig baseConfig = new BaseConfig(openApiUri, appId, appSecret);
    private final static MessageClient messageClient = new MessageClient(baseConfig);

    public static void main(String[] args) {
        pushApp();
    }

    public static void pushApp() {
        AppMessageDto appMessageDto = new AppMessageDto();
        appMessageDto.setFlags(8);
        appMessageDto.setTitle("消息test");
        appMessageDto.setContent("这是消息测试内容");
        appMessageDto.setAction("https://www.baidu.com");
        appMessageDto.setFromId(appId);
        appMessageDto.setFromName(appName);
        List<String> receivers = new ArrayList<>();
        receivers.add("18767122176");
        appMessageDto.setReceivers(receivers);
        System.out.println(messageClient.pushAppBase(appMessageDto));
    }
}
