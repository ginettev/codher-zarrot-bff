package com.tw.zarrot.controller;

import com.tw.zarrot.dto.PaymentDetails;
import com.tw.zarrot.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/payment")
    @ResponseStatus(value = HttpStatus.OK)
    public String pay(@RequestBody PaymentDetails paymentDetails) {
        return paymentService.pay(paymentDetails);
    }
}
