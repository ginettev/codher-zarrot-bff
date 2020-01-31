package com.tw.zarrot.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class Cart {
    private long userId;
    private List<CartItem> items;
}
