//package com.example.mobilego.controller;
//
//import com.example.mobilego.constant.OrderStatus;
//import com.example.mobilego.dto.OrderReqDto;
//import com.example.mobilego.util.IdGenerate;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author： ygl
// * @date： 2018/3/14-10:46
// * @Description：
// */
//@Slf4j
//@Api(description = "订单模块")
//@RestController
//@RequestMapping("/order")
//public class OrderController {
//
//    private Map<String,Object> orderDatabase = new HashMap<>();
//
//    @ApiOperation(value = "wx预生成带付款订单")
//    @PostMapping
//    public Object order(@RequestBody OrderReqDto[] reqDtoArray){
//        String orderId = IdGenerate.nextId();
//        Map<String,Object> map = new HashMap<>();
//        map.put("orderId",orderId);
//        // 可以添加逻辑判断，是否下单成功，可以去付款
//        map.put("isCanPay",true);
//        map.put("orderStatus", OrderStatus.WAIT.getCode());
//        map.put("createdDate", LocalDateTime.now());
//        map.put("orderNo", orderId);
//        map.put("totalPrice",980);
//        Map<String,Object> productData = new HashMap<>(reqDtoArray.length);
//        map.put("productData", productData);
//        for (OrderReqDto orderReqDto : reqDtoArray) {
//            Long productId = orderReqDto.getProductId();
//            int counts = orderReqDto.getCounts();
//        }
//        // 内存存储
//        orderDatabase.put(orderId,map);
//        return map;
//    }
//
//    @ApiOperation(value = "wx获取订单")
//    @GetMapping("/{id}")
//    public Object order(@PathVariable Long id){Object obj = orderDatabase.get(id.toString());
//        return obj;
//    }
//
//    @ApiOperation(value = "wx订单付款")
//    @GetMapping("/pay/{id}")
//    public Object pay(@PathVariable Long id){
//        Object obj = orderDatabase.get(id.toString());
//        ((Map)obj).put("orderStatus",2);
//        return obj;
//    }
//
//    @ApiOperation(value = "wx不同类型订单数量")
//    @GetMapping("/list/count")
//    public Object listCount(){
//        Map<String,Integer> map = new HashMap<>();
//        for (Map.Entry<String, Object> entry : orderDatabase.entrySet()) {
//            if (entry.getKey().equals("orderStatus")) {
//                Object value = entry.getValue();
//                int count = 0;
//                if (map.get(value) != null) {
//                    count = map.get(value)+1;
//                }
//                map.put(value.toString(),count);
//            }
//        }
//        return map;
//    }
//}
