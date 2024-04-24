package com.hmdp.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: RedisData
 * Description:
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.utils
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
