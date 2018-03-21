package com.example.mobilego.dao;

import com.example.mobilego.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author： ygl
 * @date： 2018/3/16-16:44
 * @Description：
 */
@Repository
public interface ProductDao extends BaseDao<Product> {
}
