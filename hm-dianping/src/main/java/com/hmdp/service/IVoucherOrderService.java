package com.hmdp.service;

import com.hmdp.dto.Result;
import com.hmdp.entity.VoucherOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * ClassName: IVoucherOrderService
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
public interface IVoucherOrderService extends IService<VoucherOrder> {

    /**
     * 秒杀优惠券
     *
     * @param voucherId {@link Long}
     * @return {@link Result}
     */
    Result secKillVoucher(Long voucherId);

    /**
     * 创建优惠券订单
     *
     * @param voucherOrder {@link VoucherOrder}
     */
    void createVoucherOrder(VoucherOrder voucherOrder);
}
