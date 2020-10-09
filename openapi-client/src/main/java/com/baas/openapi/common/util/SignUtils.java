package com.baas.openapi.common.util;

/**
 * Create Time:2020/8/31
 * User: luchao
 * Email: luc@shinemo.com
 */
public class SignUtils {

    public static String generate(String content, String secret) {
        String sign = EncryptUtils.sha256(content);
        sign = EncryptUtils.md5Hex(sign + secret);
        return sign;
    }

    public static boolean check(String sign, int bodyLength) {
        return false;
    }
}
