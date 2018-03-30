package com.example.mobilego.service;

import com.example.mobilego.entity.Category;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.support.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/3/26-15:31
 * @Description：
 */
public interface ICategoryService extends IBaseService<Category> {

    /**
     * 查询分类和对应的商品,根据sort asc排序
     * 返回结果：[{ themeName:11, categoryImgUrl:22,productList:[{productId:1,productName:22,productImgUrl:33}]}]
     * @return
     * @throws Exception
     */
    List<Map> findCategoryAndProduct() throws Exception;

    List<Category> findCategorySorted() throws Exception;
}
