package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author： ygl
 * @date： 2018/3/23-12:48
 * @Description：
 */
@Data
@Entity(name="order_product")
public class OrderProduct extends BaseEntity {

    @Column(name = "order_id", nullable = false, columnDefinition = "varchar(64) comment'订单ID'")
    private String orderId;

    @Column(name = "product_id", nullable = false, columnDefinition = "varchar(64) comment'商品ID'")
    private String productId;
}
