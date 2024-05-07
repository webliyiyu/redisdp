package com.buercorp.wangyu.common;

import lombok.AllArgsConstructor;
import lombok.Data;

//统一响应结果
@AllArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;//业务状态码  0-成功  1-失败
    private String message;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(0, "操作成功", data);
    }

    //快速返回操作成功响应结果
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(0, "操作成功", null);
    }

    public static <T> CommonResult<T> error(String message) {
        return new CommonResult<>(1, message, null);
    }
}

