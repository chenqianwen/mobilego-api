package com.example.mobilego.init;

import com.example.mobilego.constant.DataInitializerOrder;
import com.example.mobilego.dao.ProductDao;
import com.example.mobilego.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author： ygl
 * @date： 2018/3/21-15:58
 * @Description：
 * 微信测试数据
 */
@Component
public class WechatTestDataInitializer extends AbstractDataInitializer {

    @Autowired
    private ProductDao productDao;

    /**
     * 没有商品的时候，做初始化的操作
     * @return
     */
    @Override
    public boolean isNeedInit() {
        return productDao.count() == 0;
    }

    /**
     * 初始化的操作。。
     */
    @Override
    public void doInit() {

        Product product = new Product();
        product.setName("");
    }

    @Override
    public Integer getIndex() {
        return DataInitializerOrder.weixintest;
    }
}
