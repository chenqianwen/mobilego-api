package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author： ygl
 * @date： 2018/3/21-16:07
 * @Description： 商品的主题
 */
@Data
@Entity
public class Theme extends BaseEntity{
    @Column(name = "name", nullable = false, columnDefinition = "varchar(64) comment'主题名称'")
    private String name;

    @JoinTable(name = "theme_product",
            joinColumns = {@JoinColumn(name = "theme_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Product> products = new HashSet<>();

}
