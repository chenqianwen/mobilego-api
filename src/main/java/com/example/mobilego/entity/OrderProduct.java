package com.example.mobilego.entity;

import com.example.mobilego.support.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {
    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 商品数量
     */
    private Integer count;

}