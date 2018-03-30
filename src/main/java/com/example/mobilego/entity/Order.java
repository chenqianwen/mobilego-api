package com.example.mobilego.entity;

import com.example.mobilego.support.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/** 
 * @author：ygl
 * @date：2018/03/30-16:34
 * @Description：描述
 */
@Data
@Table(name = "orders")
public class Order extends BaseEntity {
    /** 
     *  订单状态
     */
    private int orderStatus;

    /** 
     *  订单总价
     */
    private BigDecimal totalPrice;

    /**
     *  订单是否可以付款：
     *  可适用于，限制于条件生成的订单不可以付款
     *  暂时先不持久化
     */
    @Transient
    private boolean isCanPay = true;

}