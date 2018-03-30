package com.example.mobilego.service.impl;

import com.example.mobilego.entity.Category;
import com.example.mobilego.entity.dto.CategoryAndProduct;
import com.example.mobilego.mapper.CategoryMapper;
import com.example.mobilego.service.ICategoryService;
import com.example.mobilego.support.service.impl.BaseServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/3/29-15:08
 * @Description：
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements ICategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        //super.setBaseMapper(categoryMapper);
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> findCategorySorted() throws Exception {
        return categoryMapper.findCategorySorted();
    }

    @Override
    public List<Map> findCategoryAndProduct() throws Exception {
        List<CategoryAndProduct> categoryAndProductList = categoryMapper.findCategoryAndProduct();

        // 最终需要返回的格式： [{ categoryName:11,categoryImgUrl:22, productList:[{productName:22,productImgUrl:33}]}]
        List<Map> list = categoryAndProductList.isEmpty() ? null : new ArrayList();
        for (CategoryAndProduct categoryAndProduct : categoryAndProductList) {
            // 获取所有的商品，组装成map
            String productId = categoryAndProduct.getProductId();
            String productName = categoryAndProduct.getProductName();
            String productImgUrl = categoryAndProduct.getProductImgUrl();
            Map<String, String> productMap = null;
            if (StringUtils.isNotBlank(productId)) {
                productMap = new HashMap<>(3);
                productMap.put("productId", productId);
                productMap.put("productName", productName);
                productMap.put("productImgUrl", productImgUrl);
            }
            // 最终的list中包含该分类名称标志：
            boolean containCategoryNameFlag = false;
            // 分鳄梨名称
            String categoryName = categoryAndProduct.getCategoryName();
            String categoryImgUrl = categoryAndProduct.getCategoryImgUrl();
            for (Map map : list) {
                String existCategoryName = (String) map.get("categoryName");
                // 分类名称已存在了
                if (categoryName.equals(existCategoryName)) {
                    // 获取分类对应的商品数据
                    List productList = (List) map.get("productList");
                    if (productMap != null) {
                        productList.add(productMap);
                    }
                    // list中包含了该分类名称
                    containCategoryNameFlag = true;
                    break;
                }
            }
            // list中没有包含了该分类名称；新建分类和对应的商品map
            if (!containCategoryNameFlag) {
                Map categoryAndProductMap = new HashMap<>(2);
                categoryAndProductMap.put("categoryName",categoryName);
                if (productMap != null) {
                    List productList = new ArrayList();
                    productList.add(productMap);
                    categoryAndProductMap.put("productList",productList);
                }
                list.add(categoryAndProductMap);
            }
        }
        return list;
    }


}
