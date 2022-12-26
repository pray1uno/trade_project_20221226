package com.its.trade.controller;

import com.its.trade.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
}
