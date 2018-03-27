package com.example.mobilego.entity.dto;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/27-15:37
 * @Description：
 */
@Data
public class ThemeAndProduct {

    /**
     * 主题名称
     */
    private String themeName;

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
