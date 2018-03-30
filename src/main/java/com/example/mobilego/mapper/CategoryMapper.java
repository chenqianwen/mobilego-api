package com.example.mobilego.mapper;

import com.example.mobilego.entity.Category;
import com.example.mobilego.entity.dto.CategoryAndProduct;
import com.example.mobilego.support.mapper.BaseMapper;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/30-15:14
 * @Description：
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryAndProduct> findCategoryAndProduct() throws Exception;

    List<Category> findCategorySorted() throws Exception;
}