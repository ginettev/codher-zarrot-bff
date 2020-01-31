package com.tw.zarrot.service;

import com.tw.zarrot.dto.Coupon;
import com.tw.zarrot.dto.Offer;
import com.tw.zarrot.dto.Restaurant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OfferServiceImpl implements OfferService {

    @Value("${service.restaurant}")
    private String restaurantService;
    @Value("${service.coupon}")
    private String couponService;

    @Override
    public Offer get() {
        RestTemplate restTemplate = new RestTemplate();
        List<Restaurant> restaurants = getRestaurants(restTemplate);
        List<Coupon> coupons = getCoupons(restTemplate);
        return new Offer(restaurants, coupons);
    }

    private List<Restaurant> getRestaurants(RestTemplate restTemplate) {
        return (List<Restaurant>) restTemplate.getForObject(restaurantService, List.class);
    }

    private List<Coupon> getCoupons(RestTemplate restTemplate) {
        return (List<Coupon>) restTemplate.getForObject(couponService, List.class);
    }
}
