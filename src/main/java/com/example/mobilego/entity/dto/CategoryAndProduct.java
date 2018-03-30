package com.example.mobilego.entity.dto;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/29-15:10
 * @Description：
 */
@Data
public class CategoryAndProduct {

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类主图
     */
    private String categoryImgUrl;

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品主图url
     */
    private String productImgUrl;
}
