package com.example.mobilego.dto;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/14-10:54
 * @Description：
 */
@Data
public class OrderReqDto {
    private Long productId;
    private int counts;
}
