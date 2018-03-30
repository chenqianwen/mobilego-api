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
import org.springframework.web.bind.annotation.PostMapping;
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
    private IOrderService iOrderService;

    @ApiOperation(value = "wx预生成带付款订单")
    @PostMapping
    public Result saveWaitOrder(@Valid @RequestBody List<OrderRequestDto> models){
        Order order = iOrderService.createOrder(models);
        return ResultHelper.ok(order);
    }
}
