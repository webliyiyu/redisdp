package com.hmdp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmdp.entity.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: VoucherMapper
 * Description: Mapper 接口
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.mapper
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public interface VoucherMapper extends BaseMapper<Voucher> {

    /**
     * 查询店铺凭证
     *
     * @param shopId {@link Long} 店铺 id
     * @return {@link List<Voucher>}
     */
    List<Voucher> queryVoucherOfShop(@Param("shopId") Long shopId);
}
