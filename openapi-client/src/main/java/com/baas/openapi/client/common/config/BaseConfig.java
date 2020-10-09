package com.baas.openapi.client.common.config;

import com.baas.openapi.client.common.factory.LogFactory;
import com.baas.openapi.client.common.util.SignUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Create Time:2020/8/31
 * User: luchao
 * Email: luc@shinemo.com
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseConfig {

    private String openApiUri;
    private String appId;
    private String appSecret;

    public String getUrl(String uri) {
        if (StringUtils.isBlank(openApiUri)) {
            throw new ApiException("openApiUri is empty,please check config");
        }
        if (StringUtils.isBlank(uri)) {
            throw new ApiException("req uri is empty");
        }
        if (!openApiUri.startsWith("http://") && !openApiUri.startsWith("https://")) {
            throw new ApiException("openApiUri format is error,please check config");
        }
        if (openApiUri.endsWith("/")) {
            return openApiUri + uri;
        }
        return openApiUri + "/" + uri;
    }

    public Map<String, Object> getHeaders(int bodyLength) {
        Map<String, Object> headers = new HashMap();
        long timestamp = System.currentTimeMillis();
        LogFactory.info("openTimestamp: {}; bodyLength: {}; openAppId: {}; appSecret: {}", timestamp, bodyLength, appId, appSecret);
        headers.put("openTimestamp", String.valueOf(timestamp));
        headers.put("openAppId", appId);
        String content = appId + timestamp + bodyLength;
        headers.put("openSign", SignUtils.generate(content, appSecret));
        return headers;
    }
}
