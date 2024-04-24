package com.hmdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;

/**
 * ClassName: IShopService
 * Description: 服务类
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.service
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public interface IShopService extends IService<Shop> {

    /**
     * 根据 id 查询店铺
     *
     * @param id {@link Long}
     * @return {@link Result}
     */
    Result queryById(Long id);

    /**
     * 更新店铺信息
     *
     * @param shop {@link Shop}
     * @return {@link Result}
     */
    Result update(Shop shop);

    /**
     * 更具类型查询店铺
     *
     * @param typeId  {@link Integer}
     * @param current {@link Integer}
     * @param x       {@link Double}
     * @param y       {@link Double}
     * @return {@link Result}
     */
    Result queryShopByType(Integer typeId, Integer current, Double x, Double y);
}
