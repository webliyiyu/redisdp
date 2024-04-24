package com.heima.item.canal;

import com.github.benmanes.caffeine.cache.Cache;
import com.heima.item.config.RedisHandler;
import com.heima.item.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * ClassName: ItemHandler
 * Description:
 * Date: 2023/04/22 AM 11:41:37
 * <p>
 * project: item-service
 * package: com.heima.item.canal
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@CanalTable("tb_item")
@Component
public class ItemHandler implements EntryHandler<Item> {

    @Autowired
    private RedisHandler redisHandler;

    @Autowired
    private Cache<Long, Item> itemCache;

    @Override
    public void insert(Item item) {
        // 写数据到 JVM 缓存
        itemCache.put(item.getId(), item);
        // 写数据到 redis
        redisHandler.saveItem(item);
    }

    @Override
    public void update(Item before, Item after) {
        // 写数据到 JVM 缓存
        itemCache.put(after.getId(), after);
        // 写数据到 redis
        redisHandler.saveItem(after);
    }

    @Override
    public void delete(Item item) {
        // 删除数据到 JVM 缓存
        itemCache.invalidate(item.getId());
        // 删除数据到 redis
        redisHandler.deleteItemById(item.getId());
    }
}
