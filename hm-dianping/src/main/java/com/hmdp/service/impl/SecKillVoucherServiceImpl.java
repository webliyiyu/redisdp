package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.entity.SecKillVoucher;
import com.hmdp.mapper.SecKillVoucherMapper;
import com.hmdp.service.ISecKillVoucherService;
import org.springframework.stereotype.Service;

/**
 * ClassName: SecKillVoucherServiceImpl
 * Description: 秒杀优惠券表，与优惠券是一对一关系 服务实现类
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.service.impl
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Service
public class SecKillVoucherServiceImpl extends ServiceImpl<SecKillVoucherMapper, SecKillVoucher> implements ISecKillVoucherService {

}
