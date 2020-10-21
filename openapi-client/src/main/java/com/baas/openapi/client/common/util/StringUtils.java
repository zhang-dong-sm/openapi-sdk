package com.baas.openapi.client.common.util;

/**
 * <p>
 * common-lang3的StringUtils
 * </p>
 *
 * @author guyuegan
 * @since 2020/10/21
 */
public class StringUtils {

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen = length(cs);
        if (strLen != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }
}
