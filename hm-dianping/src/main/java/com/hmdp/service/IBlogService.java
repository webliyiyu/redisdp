package com.hmdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmdp.dto.Result;
import com.hmdp.entity.Blog;

/**
 * ClassName: IBlogService
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
public interface IBlogService extends IService<Blog> {

    /**
     * 查询热门博客
     *
     * @param current {@link Integer}
     * @return {@link Result}
     */
    Result queryHotBlog(Integer current);

    /**
     * 根据 id 查询博客
     *
     * @param id {@link Long}
     * @return {@link Result}
     */
    Result queryBlogById(Long id);

    /**
     * 点赞
     *
     * @param id {@link Long}
     * @return {@link Result}
     */
    Result likeBlog(Long id);

    /**
     * 查询点赞博客
     *
     * @param id {@link Long}
     * @return {@link Result}
     */
    Result queryBlogLikes(Long id);

    /**
     * 新增博客
     *
     * @param blog {@link Blog}
     * @return {@link Result}
     */
    Result saveBlog(Blog blog);

    /**
     * 查询
     *
     * @param max    {@link Long}
     * @param offset {@link Integer}
     * @return {@link Result}
     */
    Result queryBlogOfFollow(Long max, Integer offset);

}
