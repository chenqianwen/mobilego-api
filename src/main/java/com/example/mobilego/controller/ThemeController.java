package com.example.mobilego.controller;

import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.entity.dto.ThemeAndProduct;
import com.example.mobilego.service.IProductService;
import com.example.mobilego.service.IThemeService;
import com.example.mobilego.util.response.Result;
import com.example.mobilego.util.response.ResultHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author： ygl
 * @date： 2018/3/29-15:50
 * @Description：
 */
@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private IThemeService iThemeService;

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/product/wx")
    public Result findThemeAndProduct() throws Exception{
        List<Theme> themeList = iThemeService.findNameSorted();
        if (CollectionUtils.isEmpty(themeList)) {
            return ResultHelper.ok(themeList);
        }
        // 所有的主题名称
        //List<String> themeNames = themeList.stream().map(Theme::getName).collect(Collectors.toList());
        String firstID = themeList.get(0)!= null?themeList.get(0).getId():null;
        List<ThemeAndProduct> products = iProductService.findByThemeId(firstID);
        // 最终的结果：
        Map<String,Object> map = new HashMap<>();
        map.put("themeData",themeList);
        map.put("productData",products);
        return ResultHelper.ok(map);
    }

    @RequestMapping("/{id}/product")
    public Result findProductByThemeId(@PathVariable String id) throws Exception{
        // TODO 查看分类商品变动的flag，再决定是否查询数据
        List<ThemeAndProduct>  themeAndProductList = iProductService.findByThemeId(id);
        return ResultHelper.ok(themeAndProductList);
    }
}
