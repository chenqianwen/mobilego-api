package com.example.mobilego.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Theme extends BaseEntity {

    @Column(name = "name", nullable = false, columnDefinition = "varchar(64) comment'主题名称'")
    private String name;

    @Column(name = "sort", columnDefinition = "smallint comment'排序'")
    private Integer sort;

}
