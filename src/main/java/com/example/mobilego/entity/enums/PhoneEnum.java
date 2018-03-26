package com.example.mobilego.entity.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * @author： ygl
 * @date： 2018/3/26-10:26
 * @Description：
 */
public enum PhoneEnum implements IEnum {
    CMCC("10086", "中国移动"),
    CUCC("10010", "中国联通"),
    CT("10000", "中国电信");

    private String value;
    private String desc;

    PhoneEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }

    @JsonValue
    public String getDesc(){
        return this.desc;
    }
}