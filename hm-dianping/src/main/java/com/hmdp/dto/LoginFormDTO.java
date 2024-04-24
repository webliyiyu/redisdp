package com.hmdp.dto;

import lombok.Data;

/**
 * ClassName: LoginFormDTO
 * Description:
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.dto
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
public class LoginFormDTO {
    private String phone;
    private String code;
    private String password;
}
