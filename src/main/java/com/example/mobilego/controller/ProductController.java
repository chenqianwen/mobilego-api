package com.example.mobilego.controller;

import com.example.mobilego.dto.ProductDto;
import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.service.IProductService;
import com.example.mobilego.service.IThemeService;
import com.example.mobilego.util.response.Result;
import com.example.mobilego.util.response.ResultHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/3/13-10:28
 * @Description：
 */
@RestController
@RequestMapping("/product")
@Slf4j
@Api(description = "商品模块")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IThemeService themeService;

    @ApiOperation(value = "保存／更新商品")
    @PostMapping
    public Result save(@RequestBody ProductDto model) {
        boolean insertFlag = productService.insert(model);
        return insertFlag?ResultHelper.ok(model):ResultHelper.error(model);
    }

    @ApiOperation(value = "查询商品")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) throws Exception {
        Product model = productService.selectById(id);
        return ResultHelper.ok(model);
    }

    @ApiOperation(value = "逻辑删除商品")
    @DeleteMapping("/{id}")
    public Result deleteLogic(@PathVariable String id) {
        boolean deleteFlag = productService.deleteById(id);
        return deleteFlag?ResultHelper.ok():ResultHelper.error();
    }

    @ApiOperation(value = "设置商品为横幅商品")
    @PutMapping("/banner")
    public Result setBanner(List<String> ids) {
        List<Product> products = productService.selectBatchIds(ids);
        products.stream().filter(one -> {
            if (one.getIsBanner() == 0) {
                one.setIsBanner(1);
                return true;
            }
            return false;
        });
        boolean isUpdateBatch = productService.updateBatchById(products);
        return isUpdateBatch?ResultHelper.ok(products):ResultHelper.error();
    }


    @ApiOperation(value = "wx首页获取横幅数据")
    @GetMapping("/wx/banner")
    public Result banner() throws Exception {
        List<Product> bannerProduct = productService.findBannerProduct();
        return ResultHelper.ok(bannerProduct);
    }


    @ApiOperation(value = "wx首页获取主题数据")
    @GetMapping("/wx/theme")
    public Result theme() throws Exception{
        List<Theme> themeList = themeService.findThemeAndProductBySort();
        String[] tabs = new String[]{"每日推荐", "热门畅销", "折扣商品"};
        int countTab = 3;
        int countProduct = 10;
        String imgUrl = "http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg";
        List list = new ArrayList();
        for (int i = 0; i < countTab; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("themeId", i);
            map.put("themeName", tabs[i]);
            map.put("productData", "热门畅销");
            List productData = new ArrayList();
            map.put("productData", productData);
            for (int i1 = 0; i1 < countProduct; i1++) {
                Map<String, Object> productMap = new HashMap<>();
                productMap.put("productId", i1);
                productMap.put("productName", "优乐美" + i1);
                productMap.put("productPrice", i1 + 1);
                productMap.put("productImgUrl", imgUrl);
                productData.add(productMap);
            }
            list.add(map);
        }

        return ResultHelper.ok();
    }

    @ApiOperation(value = "wx获取商品详情")
    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", id == 1 ? "优乐美" : "香飘票");
        map.put("description", "优乐美 香醇奶茶，红豆味儿，2018新款上市。冲水即可，方便美味。    ");
        map.put("price", id == 1 ? 8.9 : 9.9);
        List mainImgUrls = new ArrayList();
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        map.put("mainImgUrls", mainImgUrls);
        map.put("detailImgUrls", mainImgUrls);
        return map;
    }


}
