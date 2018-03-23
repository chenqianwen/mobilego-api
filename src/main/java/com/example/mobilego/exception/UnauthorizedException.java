package com.example.mobilego.exception;

/**
 * @author： ygl
 * @date： 2018/3/23-14:26
 * @Description：
 * 未授权异常
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }
}
