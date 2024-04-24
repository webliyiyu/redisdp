package com.heima.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName: ItemStock
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
@TableName("tb_item_stock")
public class ItemStock {
    /**
     * 商品id
     */
    @TableId(type = IdType.INPUT, value = "item_id")
    private Long id;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品销量
     */
    private Integer sold;
}
