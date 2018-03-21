package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author： ygl
 * @date： 2018/3/16-13:45
 * @Description：
 */
@Data
@Entity
public class OrderDetail extends BaseEntity {

    @Column(name = "order_id", nullable = false, columnDefinition = "varchar(32) comment'订单Id'")
    private String orderId;

    @Column(name = "product_id", nullable = false, columnDefinition = "varchar(32) comment'商品Id'")
    private String productId;

    @Column(name = "product_name", nullable = false, columnDefinition = "varchar(128) comment'商品名称'")
    private String productName;

    @Column(name = "product_major_img_url", nullable = false, columnDefinition = "varchar(255) comment'商品图片url'")
    private String productMajorImgUrl;

    @Column(name = "product_price", nullable = false, length = 10, scale = 2, columnDefinition = "comment'商品价格'")
    private BigDecimal productPrice;

    @Column(name = "product_count", nullable = false, length = 10, scale = 2, columnDefinition = "comment'商品数量'")
    private String productCount;

}
