package com.example.mobilego.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.mapper.ThemeMapper;
import com.example.mobilego.service.IThemeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:32
 * @Description：
 */
@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper,Theme> implements IThemeService {

    @Override
    public List<Theme> findThemeAndProductBySort() {
        return null;
    }
}
