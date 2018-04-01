package com.example.mobilego.controller;

import com.example.mobilego.constant.OrderStatus;
import com.example.mobilego.entity.Order;
import com.example.mobilego.entity.OrderProduct;
import com.example.mobilego.entity.dto.OrderRequestDto;
import com.example.mobilego.service.IOrderService;
import com.example.mobilego.util.IdGenerateHelper;
import com.example.mobilego.util.response.Result;
import com.example.mobilego.util.response.ResultHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/30-16:37
 * @Description：
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation(value = "通过ID查询订单")
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) throws Exception{
        Order order = orderService.findById(id);
        return ResultHelper.ok(order);
    }

    @ApiOperation(value = "wx预生成带付款订单")
    @PostMapping
    public Result saveWaitOrder(@Valid @RequestBody List<OrderRequestDto> models) throws Exception{
        Order order = orderService.createOrder(models);
        return ResultHelper.ok(order);
    }

    @ApiOperation(value = "wx订单付款")
    @PostMapping("/pay/{id}")
    public Result payOrder(@PathVariable String id) throws Exception{
        Order order = orderService.findById(id);
        if (order == null) {
            return ResultHelper.error("订单号不存在！");
        }
        //TODO 下单业务操作
        order.setOrderStatus(OrderStatus.PAY.getCode());
        orderService.update(order);
        return ResultHelper.ok(order);
    }

    @ApiOperation(value = "查看待付款订单的个数")
    @GetMapping("/wait/count")
    public Result countWait() throws Exception{
        int count = orderService.countByStatus(OrderStatus.WAIT, "0");
        return ResultHelper.ok(count);
    }
}
