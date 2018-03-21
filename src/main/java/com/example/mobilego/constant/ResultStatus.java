package com.example.mobilego.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @author： ygl
 * @date： 2018/3/21-11:05
 * @Description：
 */
public enum  ResultStatus {
    /**
     * 成功的返回结果
     */
    OK(0,"成功"),
    /**
     * 失败的返回结果
     */
    ERROR(1,"失败");

    @Getter
    private int code;

    @Getter
    private String msg;

    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
