package com.tw.zarrot.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tw.zarrot.dto.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class CouponServiceImpl implements CouponService {

    @Autowired
    Gson gson;

    private static final String COUPONS_JSON = "coupons.json";

    @Override
    public List<Coupon> get() {
        {
            InputStreamReader reader = null;
            Type type = new TypeToken<List<Coupon>>() {
            }.getType();
            try {
                Resource resource = new ClassPathResource(COUPONS_JSON);
                reader = new InputStreamReader(resource.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return gson.fromJson(reader, type);
        }
    }
}
