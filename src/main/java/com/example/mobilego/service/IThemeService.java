package com.example.mobilego.service;

import com.example.mobilego.entity.Theme;
import com.example.mobilego.mapper.ThemeMapper;
import com.example.mobilego.support.service.IBaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/3/26-15:31
 * @Description：
 */
public interface IThemeService extends IBaseService<Theme> {

    /**
     * 查询主题名称,根据sort asc排序
     * @return
     * @throws Exception
     */
    List<Theme> findNameSorted() throws Exception;


    /**
     * 查询主题和对应的商品,根据sort asc排序
     * 返回结果：[{ categoryName:11,productList:[{productId:1,productName:22,productImgUrl:33,prodcutPrice:22}]}]
     * @return
     * @throws Exception
     */
    List<Map> findThemeAndProduct() throws Exception;
}
