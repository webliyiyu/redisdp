package com.heima.item.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageDTO
 * Description:
 * Date: 2023/04/20 PM 5:08:21
 * <p>
 * project: item-service
 * package: com.heima.item.pojo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {
    private Long total;
    private List<Item> list;
}
