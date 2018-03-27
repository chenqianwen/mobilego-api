package com.example.mobilego.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.entity.dto.ThemeAndProduct;
import com.example.mobilego.mapper.ThemeMapper;
import com.example.mobilego.service.IThemeService;
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
 * @date： 2018/3/26-15:32
 * @Description：
 */
@Service
public class ThemeServiceImpl extends BaseServiceImpl<Theme> implements IThemeService {

    private ThemeMapper themeMapper;

    @Autowired
    public void setThemeMapper(ThemeMapper themeMapper) {
        super.setBaseMapper(themeMapper);
        this.themeMapper = themeMapper;
    }

    @Override
    public List<Map> findThemeAndProduct() throws Exception {
        List<ThemeAndProduct> themeAndProductList = themeMapper.findThemeAndProduct();

        // 最终需要返回的格式： [{ themeName:11, productList:[{productName:22,productImgUrl:33}]}]
        List<Map> list = themeAndProductList.isEmpty() ? null : new ArrayList();
        for (ThemeAndProduct themeAndProduct : themeAndProductList) {
            // 获取所有的商品，组装成map
            String productId = themeAndProduct.getProductId();
            String productName = themeAndProduct.getProductName();
            String productImgUrl = themeAndProduct.getProductImgUrl();
            Map<String, String> productMap = null;
            if (StringUtils.isNotBlank(productId)) {
                productMap = new HashMap<>(3);
                productMap.put("productId", productId);
                productMap.put("productName", productName);
                productMap.put("productImgUrl", productImgUrl);
            }
            // 最终的list中包含该主题名称标志：
            boolean containThemeNameFlag = false;
            // 主题名称
            String themeName = themeAndProduct.getThemeName();
            for (Map map : list) {
                String existThemeName = (String) map.get("themeName");
                // 主题名称已存在了
                if (themeName.equals(existThemeName)) {
                    // 获取主题对应的商品数据
                    List productList = (List) map.get("productList");
                    if (productMap != null) {
                        productList.add(productMap);
                    }
                    // list中包含了该主题名称
                    containThemeNameFlag = true;
                    break;
                }
            }
            // list中没有包含了该主题名称；新建主题和对应的商品map
            if (!containThemeNameFlag) {
                Map themeAndProductMap = new HashMap<>(2);
                themeAndProductMap.put("themeName",themeName);
                if (productMap != null) {
                    List productList = new ArrayList();
                    productList.add(productMap);
                    themeAndProductMap.put("productList",productList);
                }
                list.add(themeAndProductMap);
            }
        }
        return list;
    }
}
