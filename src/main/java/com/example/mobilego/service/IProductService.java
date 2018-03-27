package com.example.mobilego.service;

import com.example.mobilego.entity.Product;
import com.example.mobilego.support.service.IBaseService;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:11
 * @Description：
 */
public interface IProductService extends IBaseService<Product> {
    /**
     * 微信获取横幅数据
     * @return
     * @throws Exception
     */
    List<Product> findBannerProduct() throws Exception;
}
