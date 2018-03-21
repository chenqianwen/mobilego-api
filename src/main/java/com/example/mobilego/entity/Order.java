package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author： ygl
 * @date： 2018/3/16-12:53
 * @Description：
 */
@Data
@Entity
public class Order extends BaseEntity {

    @Column(name = "order_status", nullable = false, columnDefinition = " tinyint comment'订单状态'")
    private Integer orderStatus;

    @Column(name = "total_price", nullable = false, length = 10, scale = 2, columnDefinition = "comment'订单总价'")
    private BigDecimal totalPrice;

}
