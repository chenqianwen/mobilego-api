package com.example.mobilego.service;

import com.example.mobilego.dao.ProductDao;
import com.example.mobilego.entity.Product;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/16-16:45
 * @Description：
 */
public interface ProductService extends BaseService<Product>{

    /**
     * 获取横幅产品
     * @return
     */
    List<Product> findBannerProduct() throws Exception;
}
