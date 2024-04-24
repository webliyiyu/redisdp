package com.heima.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.item.mapper.ItemStockMapper;
import com.heima.item.pojo.ItemStock;
import com.heima.item.service.IItemStockService;
import org.springframework.stereotype.Service;

/**
 * ClassName: ItemStockServiceImpl
 * Description:
 * Date: 2023/04/20 PM 5:08:21
 * <p>
 * project: item-service
 * package: com.heima.item.service.impl
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Service
public class ItemStockServiceImpl extends ServiceImpl<ItemStockMapper, ItemStock> implements IItemStockService {
}
