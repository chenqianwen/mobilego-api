package com.example.mobilego.controller;

import com.example.mobilego.entity.Category;
import com.example.mobilego.entity.dto.CategoryAndProduct;
import com.example.mobilego.service.ICategoryService;
import com.example.mobilego.service.IProductService;
import com.example.mobilego.util.response.Result;
import com.example.mobilego.util.response.ResultHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/3/29-15:01
 * @Description：
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @GetMapping("/product/wx")
    public Result findCategoryAndProduct() throws Exception{
        List<Map> list = categoryService.findCategoryAndProduct();
        return ResultHelper.ok(list);
    }

    @GetMapping("/wx")
    public Result findCategory() throws Exception{
        List<Category> list = categoryService.findCategorySorted();
        return ResultHelper.ok(list);
    }

    @GetMapping("/{id}/product/wx")
    public Result findProductByCategory(@PathVariable String id) throws Exception{
        List<CategoryAndProduct> categoryAndProductList = productService.findByCategoryId(id);
        if (CollectionUtils.isEmpty(categoryAndProductList)) {
            return ResultHelper.ok();
        }

        CategoryAndProduct CategoryAndProduct = categoryAndProductList.get(0);
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName",CategoryAndProduct.getCategoryName());
        map.put("categoryImgUrl",CategoryAndProduct.getCategoryImgUrl());
        map.put("productList",categoryAndProductList);
        return ResultHelper.ok(map);

    }
}
