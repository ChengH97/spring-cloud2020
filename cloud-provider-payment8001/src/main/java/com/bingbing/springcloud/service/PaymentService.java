package com.bingbing.springcloud.service;

import com.bingbing.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
