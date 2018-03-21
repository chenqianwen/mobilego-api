package com.example.mobilego.service.impl;

import com.example.mobilego.dao.ProductDao;
import com.example.mobilego.dto.ProductDto;
import com.example.mobilego.entity.Product;
import com.example.mobilego.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/21-11:38
 * @Description：
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findBannerProduct() {
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
