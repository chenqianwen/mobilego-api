package com.example.mobilego.util.response;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/21-11:03
 * @Description：
 */
@Data
public class Result {

    private int code;

    private String msg;

    private Object data;
}
