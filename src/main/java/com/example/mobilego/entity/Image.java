package com.example.mobilego.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author： ygl
 * @date： 2018/3/22-12:26
 * @Description：
 * 图片
 */
@Data
//@Entity
public class Image extends BaseEntity{

    @Column(nullable = false,columnDefinition = "varchar(32) comment'图片名称'")
    private String name;

    @Column(nullable = false,columnDefinition = "varchar(128) comment'图片地址'")
    private String url;

    @Column(nullable = false,columnDefinition = "varchar(512) comment'图片描述'")
    private String description;
}
