package com.its.trade.controller;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    @GetMapping("/sales/upload")
    public String uploadForm() {
        return "User/user_sales";
    }

    @PostMapping("/sales/upload")
    public String upload(@ModelAttribute SaleDTO saleDTO) throws IOException {
        saleService.save(saleDTO);
        return "redirect:/";
    }


}
