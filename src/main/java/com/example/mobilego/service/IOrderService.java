package com.example.mobilego.service;

import com.example.mobilego.constant.OrderStatus;
import com.example.mobilego.entity.Order;
import com.example.mobilego.entity.dto.OrderRequestDto;
import com.example.mobilego.support.service.IBaseService;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/30-16:39
 * @Description：
 */
public interface IOrderService extends IBaseService<Order> {

    /**
     * 生成订单和明细的接口
     * @param models
     * @return
     */
    Order createOrder(List<OrderRequestDto> models);

    /**
     * 某种订单的计数
     * @param wait 订单类型
     * @param userId 用户主键
     * @return
     */
    int countByStatus(OrderStatus wait,String userId);
}
