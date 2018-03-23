package com.example.mobilego.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author： ygl
 * @date： 2018/3/23-10:11
 * @Description： 主题和产品关联表
 */
@Data
@Entity
@Table(name = "theme_product")
public class ThemeProduct extends BaseEntity {

    @Column(name = "product_id", nullable = false, columnDefinition = "varchar(64) comment'商品ID'")
    private String productId;

    @Column(name = "theme_id", nullable = false, columnDefinition = "varchar(64) comment'主题ID'")
    private String themeId;

}
