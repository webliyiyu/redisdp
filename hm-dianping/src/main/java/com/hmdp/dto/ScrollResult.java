package com.hmdp.dto;

import lombok.Data;

import java.util.List;

/**
 * ClassName: ScrollResult
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
public class ScrollResult {
    private List<?> list;
    private Long minTime;
    private Integer offset;
}
