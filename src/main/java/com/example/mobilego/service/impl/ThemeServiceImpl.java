package com.example.mobilego.service.impl;

import com.example.mobilego.dao.ThemeDao;
import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.Theme;
import com.example.mobilego.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/23-15:49
 * @Description：
 */
@Transactional(rollbackFor = Exception.class, readOnly = false)
@Service
public class ThemeServiceImpl extends BaseServiceImpl<Theme> implements ThemeService {

    private ThemeDao themeDao;

    @Autowired
    public void setThemeDao(ThemeDao themeDao) {
        super.setBaseDao(themeDao);
        this.themeDao = themeDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Theme> findThemeAndProductBySort() {
        String sql = "select * from theme";
        List resultList = entityManager.createNativeQuery(sql).getResultList();
        return resultList;
    }
}
