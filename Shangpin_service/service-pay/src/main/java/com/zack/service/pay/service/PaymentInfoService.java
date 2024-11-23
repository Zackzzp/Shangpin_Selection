package com.zack.service.pay.service;

import com.zack.model.enity.pay.PaymentInfo;

public interface PaymentInfoService {
    PaymentInfo savePaymentInfo(String orderNo);
}
