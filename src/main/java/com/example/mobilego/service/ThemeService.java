package com.example.mobilego.service;

import com.example.mobilego.entity.Theme;
import com.example.mobilego.service.impl.BaseServiceImpl;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/23-15:48
 * @Description：
 */
public interface ThemeService extends BaseService<Theme> {

    /**
     * 更新排序获取所有的主题
     * @return
     */
    List<Theme> findThemeAndProductBySort();
}
