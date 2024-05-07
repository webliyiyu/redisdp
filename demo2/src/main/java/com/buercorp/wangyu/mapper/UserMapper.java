package com.buercorp.wangyu.mapper;

import com.buercorp.wangyu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
    public interface UserMapper {
        User getUserById(Long id);

        int insertUser(User user);

        int updateUserById(User user);

        int deleteUser(Long id);

        @Select("select * from user where user_name = #{userName}")
        List<User> getUsersByName(@Param("userName") String userName);


}
