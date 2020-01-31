package com.tw.zarrot.controller;

import com.tw.zarrot.dto.Offer;
import com.tw.zarrot.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class OfferController {

    @Autowired
    OfferService offerService;

    @GetMapping("/offers")
    public Offer offers() {
        return offerService.get();
    }
}
