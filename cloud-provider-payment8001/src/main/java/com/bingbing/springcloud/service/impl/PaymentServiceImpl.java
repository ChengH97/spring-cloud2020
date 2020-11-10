package com.bingbing.springcloud.service.impl;

import com.bingbing.springcloud.dao.PaymentDao;
import com.bingbing.springcloud.entities.Payment;
import com.bingbing.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    //这个是JAVA自带的依赖注入
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
