package com.example.mobilego.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： ygl
 * @date： 2018/3/15-16:58
 * @Description： 商品
 */
@Data
@Entity
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false, columnDefinition = "varchar(64) comment'商品名称'")
    private String name;

    @Column(name = "price", nullable = false, columnDefinition = "decimal(10,2) comment'商品价格'")
    private BigDecimal price;

    @Column(name = "major_img_url", columnDefinition = "varchar(255) comment'主图url'")
    private String majorImgUrl;

    @Column(name = "minor_img_urls", columnDefinition = "varchar(512) comment'次图url'")
    private String minorImgUrls;

    @Column(name = "detail_img_urls", columnDefinition = "varchar(1024) comment'明细图url'")
    private String detailImgUrls;

    @Column(name = "description", columnDefinition = "varchar(1024) comment'商品的描述'")
    private String description;

    @Column(name = "is_banner", columnDefinition = "tinyint default 0 comment'商品的描述'")
    private Integer isBanner = 0;

}
