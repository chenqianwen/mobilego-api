package com.example.mobilego.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author： ygl
 * @date： 2018/3/30-16:43
 * @Description：
 */
@ApiModel(description="预生成订单请求数据")
@Data
public class OrderRequestDto {

    @ApiModelProperty(name = "商品ID")
    @NotBlank(message = "商品ID不能为空")
    private String productId;

    @ApiModelProperty(name = "订单数量")
    @NotBlank(message = "商品数量不能为空")
    private int counts;
}
