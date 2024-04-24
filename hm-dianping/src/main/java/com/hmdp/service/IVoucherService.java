package com.hmdp.service;

import com.hmdp.dto.Result;
import com.hmdp.entity.Voucher;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * ClassName: IVoucherService
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
public interface IVoucherService extends IService<Voucher> {

    /**
     * 查询店铺优惠券
     *
     * @param shopId {@link Long}
     * @return {@link Result}
     */
    Result queryVoucherOfShop(Long shopId);

    /**
     * 添加秒杀优惠券
     *
     * @param voucher {@link Voucher}
     */
    void addSecKillVoucher(Voucher voucher);
}
