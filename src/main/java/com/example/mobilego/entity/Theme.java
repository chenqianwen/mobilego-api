package com.example.mobilego.entity;

import com.example.mobilego.support.entity.BaseEntity;
import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/3/21-16:07
 * @Description： 商品的主题
 */
@Data
public class Theme extends BaseEntity {

    /**
     * 主题名称
     */
    private String name;

    /**
     * 排序，越小越排前面
     */
    private Integer sort;

}
