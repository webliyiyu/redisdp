package com.hmdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmdp.dto.Result;
import com.hmdp.entity.Follow;

/**
 * ClassName: IFollowService
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
public interface IFollowService extends IService<Follow> {

    /**
     * follow
     *
     * @param followUserId {@link Long}
     * @param isFollow     {@link Boolean}
     * @return {@link Result}
     */
    Result follow(Long followUserId, Boolean isFollow);

    /**
     * isFollow
     *
     * @param followUserId {@link Long}
     * @return {@link Result}
     */
    Result isFollow(Long followUserId);

    /**
     * followCommons
     *
     * @param id {@link Long}
     * @return {@link Result}
     */
    Result followCommons(Long id);
}
