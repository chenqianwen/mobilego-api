package com.example.mobilego.mapper;

import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.dto.CategoryAndProduct;
import com.example.mobilego.entity.dto.ThemeAndProduct;
import com.example.mobilego.support.mapper.BaseMapper;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:14
 * @Description：
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 查询横幅商品
     * @return
     */
    List<Product> findBannerProduct()  throws Exception;

    /**
     * 通过主题ID查询商品
     * @return
     * @throws Exception
     */
    List<ThemeAndProduct> findByThemeId(String themeId)  throws Exception;

    /**
     * 通过分类ID查询商品
     * @return
     * @throws Exception
     */
    List<CategoryAndProduct> findByCategoryId(String categoryId)  throws Exception;

}
