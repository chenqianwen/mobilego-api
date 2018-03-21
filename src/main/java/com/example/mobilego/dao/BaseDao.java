package com.example.mobilego.dao;

import com.example.mobilego.entity.BaseEntity;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/16-16:33
 * @Description：
 */
@NoRepositoryBean
public interface BaseDao<T extends BaseEntity> extends JpaRepository<T,String> ,JpaSpecificationExecutor<T> {

    /**
     * 获取entityManager
     * @return
     */
    public EntityManager getEm();

    /**
     * 通过 ID 数组或者集合 查询数据集
     * @param ids
     * @return
     */
    List<T> findByIds(Iterable<String> ids);

}
