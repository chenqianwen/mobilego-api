package com.example.mobilego.service;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.mapper.ThemeMapper;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:31
 * @Description：
 */
public interface IThemeService extends IService<Theme> {
    /**
     * 查询主题和对应的商品
     * @return
     */
    List<Theme> findThemeAndProductBySort();
}
