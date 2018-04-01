package com.example.mobilego.constant;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author： ygl
 * @date： 2018/3/15-12:38
 * @Description：
 */
public enum OrderStatus {
    /**
     * 所有订单状态
     */
    ALL(0,"所有"),
    /**
     * 待付款状态
     */
    WAIT(1,"待付款"),
    /**
     * 待付款状态
     */
    PAY(2,"已付款"),
    /**
     * 等评价状态
     */
    COMMENT(3,"待评价"),
    /**
     * 已完成状态
     */
    FINISH(4,"已完成");

    @Setter
    @Getter
    int code;
    @Setter
    @Getter
    String message;

    OrderStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
