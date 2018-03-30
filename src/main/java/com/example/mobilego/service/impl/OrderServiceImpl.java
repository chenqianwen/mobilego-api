package com.example.mobilego.service.impl;

import com.example.mobilego.constant.OrderStatus;
import com.example.mobilego.entity.Order;
import com.example.mobilego.entity.OrderProduct;
import com.example.mobilego.entity.Product;
import com.example.mobilego.entity.dto.OrderRequestDto;
import com.example.mobilego.mapper.OrderMapper;
import com.example.mobilego.service.IOrderProductService;
import com.example.mobilego.service.IOrderService;
import com.example.mobilego.service.IProductService;
import com.example.mobilego.support.service.impl.BaseServiceImpl;
import com.example.mobilego.util.IdGenerateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/30-16:40
 * @Description：
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements IOrderService {

    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        //super.setBaseMapper(orderMapper);
        this.orderMapper = orderMapper;
    }

    @Autowired
    private IOrderProductService iOrderProductService;

    @Autowired
    private IProductService iProductService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order createOrder(List<OrderRequestDto> models) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.WAIT.getCode());
        order.setId(IdGenerateHelper.snowflakeId());
        // 订单的总价
        BigDecimal total = null;
        // 保存明细
        List<OrderProduct> orderProductList = new ArrayList<>();
        for (OrderRequestDto model : models) {
            OrderProduct orderProduct = new OrderProduct();
            String productId = model.getProductId();
            Product product = iProductService.findById(productId);
            int counts = model.getCounts();
            orderProduct.setOrderId(order.getId());
            orderProduct.setProductId(productId);
            orderProduct.setCount(counts);
            orderProductList.add(orderProduct);
            // 某一种商品的价格
            BigDecimal partTotal = product.getPrice().multiply(new BigDecimal(counts));
            if (total == null) {
                total = partTotal;
            } else {
                total.add(partTotal);
            }
        }
        iOrderProductService.insertList(orderProductList);

        // 保存订单
        order.setTotalPrice(total);
        insert(order);
        return  order;
    }
}
