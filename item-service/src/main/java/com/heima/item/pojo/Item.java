package com.heima.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * ClassName: Item
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
@TableName("tb_item")
public class Item {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    @Id
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 价格（分）
     */
    private Long price;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 分类名称
     */
    private String category;

    /**
     * 品牌名称
     */
    private String brand;

    /**
     * 规格
     */
    private String spec;

    /**
     * 商品状态 1-正常，2-下架
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    @Transient
    private Integer stock;

    @TableField(exist = false)
    @Transient
    private Integer sold;
}
