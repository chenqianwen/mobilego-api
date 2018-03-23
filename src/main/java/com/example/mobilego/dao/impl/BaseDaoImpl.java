package com.example.mobilego.dao.impl;

import com.example.mobilego.dao.BaseDao;
import com.example.mobilego.entity.BaseEntity;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Getter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
 * @date： 2018/3/21-10:27
 * @Description：
 */
public class BaseDaoImpl<T extends BaseEntity> extends SimpleJpaRepository<T,String> implements BaseDao<T>{

    private final EntityManager entityManager;

    public BaseDaoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


    /**
     * 通过ID查询
     */
    @Override
    public T getOne(String id) {
        List<T> list = findAll(new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicateList = new ArrayList<>();
                Path<Long> idRoot = root.get("id");
                predicateList.add(builder.equal(idRoot,id));
                Path<Integer> isDeletedRoot = root.get("isDeleted");
                predicateList.add(builder.equal(isDeletedRoot,0));

                Predicate[] predicateArray = new Predicate[predicateList.size()];
                query.where(builder.and(predicateList.toArray(predicateArray)));
                query.orderBy(builder.asc(root.get("id")));

                return query.getRestriction();
            }
        });
        return list.isEmpty()?null:list.get(0);
    }

}
