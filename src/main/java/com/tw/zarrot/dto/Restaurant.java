package com.tw.zarrot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Restaurant {
    private long id;
    private String name;
    private String category;
    private String imageUrl;
    private String rating;
    private List<String> cuisines;
    private List<Discount> discounts;
}
