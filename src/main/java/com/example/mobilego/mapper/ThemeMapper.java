package com.example.mobilego.mapper;

import com.example.mobilego.entity.Theme;
import com.example.mobilego.entity.dto.ThemeAndProduct;
import com.example.mobilego.support.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/3/26-15:30
 * @Description：
 */
public interface ThemeMapper extends BaseMapper<Theme> {

    /**
     * 获取主题和对应的商品
     * @return
     * @throws Exception
     */
    List<ThemeAndProduct> findThemeAndProduct() throws Exception;

    /**
     * 获取名称 根据sort asc 排序
     * @return
     * @throws Exception
     */
    List<Theme> findNameSorted() throws Exception;
}
