package com.example.mobilego.service.impl;

import com.example.mobilego.dao.BaseDao;
import com.example.mobilego.entity.BaseEntity;
import com.example.mobilego.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/21-11:17
 * @Description：
 */
@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public T findOne(String id) {
        return baseDao.getOne(id);
    }

    @Override
    public List<T> findByIds(Iterable<String> ids) {
        return baseDao.findByIds(ids);
    }

    @Override
    public T save(T t) {
        return baseDao.save(t);
    }

    @Override
    public List<T> save(List<T> ts) {
        return baseDao.saveAll(ts);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void deleteById(String id) {
        baseDao.deleteById(id);

    }

    @Override
    public T deleteLogic(T t) {
        t.setIsDeleted(1);
        return save(t);
    }

    @Override
    public T deleteLogicById(String id) {
        T one = findOne(id);
        one.setIsDeleted(1);
        return save(one);
    }

    @Override
    public List<T> findAll(Specification<T> spec) {
        return baseDao.findAll(spec);
    }
}