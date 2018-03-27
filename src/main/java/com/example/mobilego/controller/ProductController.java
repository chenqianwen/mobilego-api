package com.example.mobilego.controller;

import com.example.mobilego.dto.ProductDto;
import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.entity.dto.ProductDetail;
import com.example.mobilego.service.IProductService;
import com.example.mobilego.service.IThemeService;
import com.example.mobilego.util.response.Result;
import com.example.mobilego.util.response.ResultHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
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
    public Result insert(@RequestBody ProductDto model) {
        productService.insert(model);
        return ResultHelper.ok(model);
    }

    @ApiOperation(value = "查询商品")
    @GetMapping("/{id}")
    public Result get(@PathVariable String id) throws Exception {
        Product model = productService.findById(id);
        return ResultHelper.ok(model);
    }

    @ApiOperation(value = "逻辑删除商品")
    @DeleteMapping("/{id}")
    public Result deleteLogic(@PathVariable String id) {
        int row = productService.deleteById(id);
        return row > 0 ? ResultHelper.ok() : ResultHelper.error("数据不存在");
    }

    @ApiOperation(value = "设置商品为横幅商品")
    @PutMapping("/banner")
    public Result setBanner(List<String> ids) {
        List<Product> products = productService.findByIdList(ids);
        products.stream().filter(one -> {
            if (one.getIsBanner() == 0) {
                one.setIsBanner(1);
                return true;
            }
            return false;
        });
        int rows = productService.updateList(products);
        return ResultHelper.ok(rows);
    }


    @ApiOperation(value = "wx首页获取横幅数据")
    @GetMapping("/wx/banner")
    public Result banner() throws Exception {
        List<Product> bannerProduct = productService.findBannerProduct();
        return ResultHelper.ok(bannerProduct);
    }


    @ApiOperation(value = "wx首页获取主题数据")
    @GetMapping("/wx/theme")
    public Result theme() throws Exception {
        List<Map> themeAndProductList = themeService.findThemeAndProduct();
        return ResultHelper.ok(themeAndProductList);
    }

    @ApiOperation(value = "wx获取商品详情")
    @GetMapping("/wx/{id}/detail")
    public Result detail(@PathVariable String id) {
        Product product = productService.findById(id);
        ProductDetail productDetail = new ProductDetail();
        BeanUtils.copyProperties(product,productDetail);
        String minorImgUrls = product.getMinorImgUrls();
        String detailImgUrls = product.getDetailImgUrls();
        productDetail.setMinorImgUrls(StringUtils.split(minorImgUrls,","));
        productDetail.setDetailImgUrls(StringUtils.split(detailImgUrls,","));
        return ResultHelper.ok(productDetail);
    }


}
