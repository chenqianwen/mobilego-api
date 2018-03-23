package com.example.mobilego.service.impl;

import com.example.mobilego.dao.ProductDao;
import com.example.mobilego.entity.Product;
import com.example.mobilego.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/21-11:38
 * @Description：
 */
@Transactional(rollbackFor = Exception.class,readOnly = true)
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        super.setBaseDao(productDao);
        this.productDao = productDao;
    }

    @Override
    public List<Product> findBannerProduct() throws Exception{
        Specification<Product> spec = (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            Path<Integer> isBanner = root.get("isBanner");
            Path<Integer> isDeleted = root.get("isDeleted");
            predicateList.add(builder.equal(isBanner, 1));
            predicateList.add(builder.equal(isDeleted, 0));

            Predicate[] predicateArray = new Predicate[predicateList.size()];
            query.where(builder.and(predicateList.toArray(predicateArray)));
            return query.getRestriction();
        };
        return findAll(spec);
    }
}
