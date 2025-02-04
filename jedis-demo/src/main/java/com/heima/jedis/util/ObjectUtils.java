package com.heima.jedis.util;

import com.sun.istack.internal.Nullable;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * ClassName: ObjectUtils
 * Description:
 * Date: 2023/04/23 AM 10:24:37
 * <p>
 * project: jedis-demo
 * package: com.heima.jedis.util
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public class ObjectUtils {

    public static boolean isEmpty(@Nullable Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof Optional) {
            return !((Optional<?>) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        // else
        return false;
    }
}
