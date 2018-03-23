package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： ygl
 * @date： 2018/3/16-12:01
 * @Description：
 * 分类
 */
@Data
@Entity
public class Category extends BaseEntity{

    @Column(name = "name",nullable = false,columnDefinition = "varchar(64) comment'分类名称'")
    private String name;

    @Column(name = "major_img_url",columnDefinition = "varchar(255) comment'分类主图'")
    private String majorImgUrl;

    @Column(name = "sort",columnDefinition = "smallint comment'分类排序'")
    private Integer sort;

}
