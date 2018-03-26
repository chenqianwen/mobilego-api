package com.example.mobilego.entity;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/21-16:07
 * @Description： 商品的主题
 */
@Data
public class Theme extends SupperEntity<Theme> {

    /**
     * 主题名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

}
