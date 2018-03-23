package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： ygl
 * @date： 2018/3/16-12:53
 * @Description：
 */
@Data
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "order_status", nullable = false, columnDefinition = " tinyint comment'订单状态'")
    private Integer orderStatus;

    @Column(name = "total_price", nullable = false, columnDefinition = "decimal(10,2) comment'订单总价'")
    private BigDecimal totalPrice;

}
