package com.tw.zarrot.service;

import com.tw.zarrot.dto.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    CartService cartService;

    @Override
    public String pay(PaymentDetails paymentDetails) {
        boolean areItemsInCart = cartService.areItemsInCart(paymentDetails.getUser());
        if (areItemsInCart) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Payment Successful";
        }
        return "No Items in Cart";
    }
}
