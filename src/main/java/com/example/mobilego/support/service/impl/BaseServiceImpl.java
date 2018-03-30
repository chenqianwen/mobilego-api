package com.example.mobilego.support.service.impl;

import com.example.mobilego.support.auditor.AuditorService;
import com.example.mobilego.support.entity.BaseEntity;
import com.example.mobilego.support.mapper.BaseMapper;
import com.example.mobilego.support.service.IBaseService;
import com.example.mobilego.util.IdGenerateHelper;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26
 * @Description：
 */
public class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

    @Autowired
    private AuditorService auditorService;

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public int insert(T t) {
        if (StringUtils.isBlank(t.getId())) {
            t.setId(IdGenerateHelper.snowflakeId());
        }
        t.setCreatedBy(auditorService.getCurrentAuditor());
        t.setCreatedDate(new Date());
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Date());
        return baseMapper.insertSelective(t);
    }

    @Override
    public int insertList(List<T> list) {
        for (T t : list) {
            if (StringUtils.isBlank(t.getId())) {
                t.setId(IdGenerateHelper.snowflakeId());
            }
            t.setCreatedBy(auditorService.getCurrentAuditor());
            t.setCreatedDate(new Date());
            t.setUpdatedBy(auditorService.getCurrentAuditor());
            t.setUpdatedDate(new Date());
        }
        return baseMapper.insertList(list);
    }

    @Override
    public int delete(T t) {
        return baseMapper.delete(t);
    }

    @Override
    public int deleteById(String id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(T t) {
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Date());
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateList(List<T> list) {
        int rows = 0;
        for (T t : list) {
            t.setUpdatedBy(auditorService.getCurrentAuditor());
            t.setUpdatedDate(new Date());
            rows += update(t);
        }
        return rows;
    }

    @Override
    public T findById(String id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<T> findByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }

    @Override
    public List<T> findByIdArray(String[] idArray) {
        String ids = StringUtils.join(idArray, ",");
        return findByIds(ids);
    }

    @Override
    public List<T> findByIdList(List<String> idList) {
        String ids = StringUtils.join(idList, ",");
        return findByIds(ids);
    }
}
