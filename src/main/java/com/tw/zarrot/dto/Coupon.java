package com.tw.zarrot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Coupon {
    private long id;
    private String title;
    private CouponType type;
    private String code;
    private String imageUrl;
    private List<String> details;
}
