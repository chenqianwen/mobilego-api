package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author： ygl
 * @date： 2018/3/15-16:58
 * @Description： 商品
 */
@Data
public class Product extends SupperEntity<Product> {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 主图url
     */
    private String majorImgUrl;

    /**
     *次图url
     */
    private String minorImgUrls;

    /**
     *明细图url
     */
    private String detailImgUrls;

    /**
     *商品的描述
     */
    private String description;

    /**
     * 是否横幅商品
     */
    private Integer isBanner = 0;

}
