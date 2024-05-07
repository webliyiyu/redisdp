package com.buercorp.wangyu.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * ClassName: User
 * Description:
 * Date: 2023/04/14 AM 11:37:56
 * <p>
 * project: redis-demo
 * package: com.heima.redis.pojo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "user")
@Builder
public class User implements Serializable {
    // 开启Spring Redis Cache时，加入序列化
    private static final long serialVersionUID = -4947062488310146862L;
    private Long id;
    private String userName;
    private Integer age;
}
