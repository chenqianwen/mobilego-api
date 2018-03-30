package com.example.mobilego.entity;

import com.example.mobilego.support.entity.BaseEntity;
import lombok.Data;

/** 
 * @author：ygl
 * @date：2018/03/29-15:25
 * @Description：描述
 */
@Data
public class Category extends BaseEntity {
    /** 
     *  分类主图
     */
    private String majorImgUrl;

    /** 
     *  分类名称
     */
    private String name;

    /** 
     *  分类排序
     */
    private Short sort;

}