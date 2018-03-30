package com.example.mobilego.service.impl;

import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.dto.CategoryAndProduct;
import com.example.mobilego.entity.dto.ThemeAndProduct;
import com.example.mobilego.mapper.ProductMapper;
import com.example.mobilego.service.IProductService;
import com.example.mobilego.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:12
 * @Description：
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements IProductService{


    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        //super.setBaseMapper(productMapper);
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findBannerProduct() throws Exception{
        List<Product> list = productMapper.findBannerProduct();
        return list;
    }

    @Override
    public List<ThemeAndProduct> findByThemeId(String themeId) throws Exception {
        return productMapper.findByThemeId(themeId);
    }

    @Override
    public List<CategoryAndProduct> findByCategoryId(String categoryId) throws Exception {
        return productMapper.findByCategoryId(categoryId);
    }
}
