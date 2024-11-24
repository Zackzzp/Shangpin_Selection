package com.zack.service.pay.service;

import com.zack.model.enity.pay.PaymentInfo;

import java.util.Map;

public interface PaymentInfoService {
    PaymentInfo savePaymentInfo(String orderNo);

    void updatePaymentStatus(Map<String, String> map, Integer payType);
}
