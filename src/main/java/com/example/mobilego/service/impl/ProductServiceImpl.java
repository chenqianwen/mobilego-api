package com.example.mobilego.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mobilego.entity.Product;
import com.example.mobilego.mapper.ProductMapper;
import com.example.mobilego.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-15:12
 * @Description：
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements IProductService{

    @Override
    public List<Product> findBannerProduct() throws Exception{
        return null;
    }
}
