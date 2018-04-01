package com.example.mobilego.mapper;

import com.example.mobilego.entity.Order;
import com.example.mobilego.support.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/30-15:14
 * @Description：
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 通过订单状态 和 订单所属消费者ID，统计订单个数
     * @param status
     * @param userId
     * @return
     */
    int countByStatus(@Param("status") int status,@Param("userId") String userId);
}