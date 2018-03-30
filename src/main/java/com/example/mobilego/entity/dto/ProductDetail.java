package com.example.mobilego.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author： ygl
 * @date： 2018/3/27-17:02
 * @Description：
 */
@Data
public class ProductDetail {

    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private String majorImgUrl;

    private String[] minorImgUrls;

    private String[] detailImgUrls;

}
