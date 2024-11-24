package com.zack.model.dto.order;

import com.zack.model.enity.order.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderInfoDto {

    //送货地址id
    private Long userAddressId;

    //运费
    private BigDecimal feightFee;
    //备注
    private String remark;
    //订单明细
    private List<OrderItem> orderItemList;
}