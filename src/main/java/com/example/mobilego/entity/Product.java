package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @Column(name = "price", nullable = false, length = 10, scale = 2, columnDefinition = "comment'商品价格'")
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

    @JoinTable(name = "theme_product",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "theme_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Theme> themes = new HashSet<>();

    @JoinTable(name = "category_product",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Category> categories = new HashSet<>();
}
