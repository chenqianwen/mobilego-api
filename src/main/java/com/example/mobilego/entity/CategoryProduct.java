package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author： ygl
 * @date： 2018/3/23-10:59
 * @Description：
 */
@Data
@Entity
@Table(name="category_product")
public class CategoryProduct extends BaseEntity{

    @Column(name = "product_id", nullable = false, columnDefinition = "varchar(64) comment'商品ID'")
    private String productId;

    @Column(name = "category_id", nullable = false, columnDefinition = "varchar(64) comment'分类ID'")
    private String categoryId;

}
