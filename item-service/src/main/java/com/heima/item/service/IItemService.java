package com.heima.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.item.pojo.Item;

/**
 * ClassName: IItemService
 * Description:
 * Date: 2023/04/20 PM 5:08:21
 * <p>
 * project: item-service
 * package: com.heima.item.service
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public interface IItemService extends IService<Item> {

    /**
     * 保存商品
     *
     * @param item {@link Item}
     */
    void saveItem(Item item);
}
