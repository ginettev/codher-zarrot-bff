package com.tw.zarrot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Offer {
    private List<Restaurant> restaurants;
    private List<Coupon> coupons;
}
