package com.example.mobilego.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.User;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:11
 * @Description：
 */
public interface IProductService extends IService<Product> {
    /**
     * 微信获取横幅数据
     * @return
     */
    List<Product> findBannerProduct() throws Exception;
}
