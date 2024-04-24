package com.hmdp.controller;


import com.hmdp.dto.Result;
import com.hmdp.service.IVoucherOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: VoucherOrderController
 * Description: 前端控制器
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.controller
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@RestController
@RequestMapping("/voucher-order")
public class VoucherOrderController {

    @Resource
    private IVoucherOrderService voucherOrderService;

    @PostMapping("secKill/{id}")
    public Result secKillVoucher(@PathVariable("id") Long voucherId) {
        return voucherOrderService.secKillVoucher(voucherId);
    }
}
