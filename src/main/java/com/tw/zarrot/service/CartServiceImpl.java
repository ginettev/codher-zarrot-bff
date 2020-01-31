package com.tw.zarrot.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tw.zarrot.dto.Cart;
import com.tw.zarrot.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartServiceImpl implements CartService {

    private static final String CART_JSON = "carts.json";

    @Autowired
    Gson gson;

    @Override
    public boolean areItemsInCart(User user) {
        InputStreamReader reader = null;
        Type type = new TypeToken<List<Cart>>() {
        }.getType();
        try {
            Resource resource = new ClassPathResource(CART_JSON);
            reader = new InputStreamReader(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Cart> carts = gson.fromJson(reader, type);
        List<Cart> filteredCartOfUser = carts.stream().filter(p -> p.getUserId() == user.getUserId()).collect(Collectors.toList());
        return !filteredCartOfUser.isEmpty();
    }
}
