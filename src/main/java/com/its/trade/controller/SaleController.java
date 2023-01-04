package com.its.trade.controller;

import com.its.trade.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    @GetMapping("/sales/upload")
    public String uploadForm() {
        return "User/user_sales";
    }
}
