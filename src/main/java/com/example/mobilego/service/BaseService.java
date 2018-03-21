package com.example.mobilego.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/16-16:47
 * @Description：
 * 基础服务提供常用的方法
 */
public interface BaseService<T> {

    /**
     * 通过Specification查找实体
     * @param spec
     * @return
     */
    public List<T> findAll(Specification<T> spec);

    /**
     * 通过id查找实体
     * @param id
     * @return
     */
    public T findOne(String id);

    /**
     * 通过ids 集合或者数组 查找实体
     * @param ids
     * @return
     */
    public List<T> findByIds(Iterable<String> ids);

    /**
     * 保存或者更新
     * @param t
     * @return
     */
    public T save(T t);

    /**
     * 保存或者更新 实体集合
     * @param ts
     * @return
     */
    public List<T> save(List<T> ts);

    /**
     * 物理删除
     * @param t 实体
     * @return
     */
    public void delete(T t);

    /**
     * 逻辑删除
     * @param t 实体
     * @return
     */
    public T deleteLogic(T t);

    /**
     * 物理删除
     * @param id 主键
     * @return
     */
    public void deleteById(String id);

    /**
     * 逻辑删除
     * @param id 主键
     * @return
     */
    public T deleteLogicById(String id);
}
