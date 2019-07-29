package com.example.demo.TokenInterface;

/**
 * API接口的基础返回类
 *
 * @author Cloud
 * @version 1.0
 * @since 2019/1/7
 */
public class BaseResponse<T> {
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
}