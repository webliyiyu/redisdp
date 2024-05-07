-- 创建名为'user'的表，并添加表注释
CREATE TABLE `user` (
    -- 'id'列，类型为bigint(20)，不允许为空，自动递增，列注释说明这是用户的唯一标识
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
    -- 'userName'列，类型为varchar(255)，允许为空，列注释说明这是用户的用户名
                        `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
    -- 'age'列，类型为int(11)，允许为空，列注释说明这是用户的年龄
                        `age` int(11) DEFAULT NULL COMMENT '年龄',
    -- 主键约束，以'id'列作为主键
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 指定存储引擎为InnoDB，字符集为utf8，表注释说明这是一个用户信息表
COMMENT='用户信息表';