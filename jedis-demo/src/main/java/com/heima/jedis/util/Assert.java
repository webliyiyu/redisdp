package com.heima.jedis.util;

/**
 * ClassName: Assert
 * Description:
 * Date: 2023/04/23 AM 10:23:37
 * <p>
 * project: jedis-demo
 * package: com.heima.jedis.util
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public class Assert {
    public static void notNull(Object obj, String msg) {
        if (obj == null) {
            throw new RuntimeException(msg);
        }
    }

    public static void hasText(String str, String msg) {
        if (str == null) {
            throw new RuntimeException(msg);
        }
        if (str.trim().isEmpty()) {
            throw new RuntimeException(msg);
        }
    }
}
