package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * @author： ygl
 * @date： 2018/3/16-13:45
 * @Description：
 */
@Data
//@Entity
public class OrderDetail extends BaseEntity {

    /**
     * cascade(级联)：all(所有)，merge(更新)，refresh(查询)，persistence(保存)，remove(删除)
     * fetch: eager:立即加载  one的一方默认是立即加载 lazy:懒加载    many的一方默认是懒加载
     * optional:是否可选,外键是否允许为空
     * JoinColumn:指定外键名
     */
    @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER,optional=false)
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name = "product_id", nullable = false, columnDefinition = "varchar(64) comment'商品Id'")
    private String productId;

    @Column(name = "product_name", nullable = false, columnDefinition = "varchar(128) comment'商品名称'")
    private String productName;

    @Column(name = "product_major_img_url", nullable = false, columnDefinition = "varchar(255) comment'商品图片url'")
    private String productMajorImgUrl;

    @Column(name = "product_price", nullable = false, columnDefinition = "decimal(10,2) comment'商品价格'")
    private BigDecimal productPrice;

    @Column(name = "product_count", nullable = false, columnDefinition = "decimal(10,2) comment'商品数量'")
    private String productCount;

}
