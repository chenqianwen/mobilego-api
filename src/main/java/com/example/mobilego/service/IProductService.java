package com.example.mobilego.service;

import com.example.mobilego.entity.Category;
import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.dto.CategoryAndProduct;
import com.example.mobilego.entity.dto.ThemeAndProduct;
import com.example.mobilego.support.service.IBaseService;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:11
 * @Description：
 */
public interface IProductService extends IBaseService<Product> {
    /**
     * 微信获取横幅数据
     * @return
     * @throws Exception
     */
    List<Product> findBannerProduct() throws Exception;

    /**
     * 根据主题ID获取商品信息
     * @return
     * @throws Exception
     */
    List<ThemeAndProduct> findByThemeId(String themeId) throws Exception;

    /**
     * 根据分类ID获取商品信息
     * @param categoryId
     * @return
     * @throws Exception
     */
    List<CategoryAndProduct> findByCategoryId(String categoryId) throws Exception;

}
