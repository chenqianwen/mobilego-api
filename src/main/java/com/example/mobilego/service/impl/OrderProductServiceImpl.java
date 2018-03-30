package com.example.mobilego.service.impl;

import com.example.mobilego.entity.OrderProduct;
import com.example.mobilego.mapper.OrderProductMapper;
import com.example.mobilego.service.IOrderProductService;
import com.example.mobilego.support.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/3/30-17:13
 * @Description：
 */
@Service
public class OrderProductServiceImpl extends BaseServiceImpl<OrderProduct> implements IOrderProductService {

    private OrderProductMapper orderProductMapper;

    @Autowired
    public OrderProductMapper getOrderProductMapper() {
        //super.setBaseMapper(orderProductMapper);
        return orderProductMapper;
    }
}
