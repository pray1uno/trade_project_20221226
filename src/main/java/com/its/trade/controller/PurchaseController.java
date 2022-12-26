package com.its.trade.controller;

import com.its.trade.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;
}
