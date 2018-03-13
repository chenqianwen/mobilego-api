package com.example.mobilego.controller;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @ApiOperation(value = "wx首页获取横幅数据")
    @GetMapping("/banner")
    public Object banner(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("productId","1");
        map1.put("productName","优乐美0");
        map1.put("productImgUrl","http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        Map<String,String> map2 = new HashMap<>();
        map2.put("productId","2");
        map2.put("productName","优乐美1");
        map2.put("productImgUrl","http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        Map<String,String> map3 = new HashMap<>();
        map3.put("productId","2");
        map3.put("productName","优乐美2");
        map3.put("productImgUrl","http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg");
        List list = new ArrayList(3);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;
    }


    @ApiOperation(value = "wx首页获取主题数据")
    @GetMapping("/theme")
    public Object theme(){
        String[] tabs = new String[]{"每日推荐","热门畅销","折扣商品"};
        int countTab =3;
        int countProduct = 10;
        String imgUrl = "http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg";
        List list = new ArrayList();
        for (int i = 0; i < countTab; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("themeId",i);
            map.put("themeName",tabs[i]);
            map.put("productData","热门畅销");
            List productData = new ArrayList();
            map.put("productData",productData);
            for (int i1 = 0; i1 < countProduct; i1++) {
                Map<String,Object> productMap = new HashMap<>();
                productMap.put("productId",i1);
                productMap.put("productName","优乐美"+i1);
                productMap.put("productPrice",i1+1);
                productMap.put("productImgUrl",imgUrl);
                productData.add(productMap);
            }
            list.add(map);
        }

        return list;
    }

    @ApiOperation(value = "wx获取商品详情")
    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable Long id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",id==1?"优乐美":"香飘票");
        map.put("description","优乐美 香醇奶茶，红豆味儿，2018新款上市。冲水即可，方便美味。    ");
        map.put("price",id==1?8.9:9.9);
        List mainImgUrls = new ArrayList();
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175866434296.jpg");
        mainImgUrls.add("http://img06.tooopen.com/images/20160818/tooopen_sy_175833047715.jpg");
        map.put("mainImgUrls",mainImgUrls);
        map.put("detailImgUrls",mainImgUrls);
        return map;
    }



}
