package com.bingbing.springcloud.controller;

import com.bingbing.springcloud.entities.CommonResult;
import com.bingbing.springcloud.entities.Payment;
import com.bingbing.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "success,serverPort:" + serverPort);
        } else {
            return new CommonResult(444, "fail");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "success,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "fail");
        }
    }
}
