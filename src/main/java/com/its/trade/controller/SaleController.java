package com.its.trade.controller;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/")
    public String findAll(Model model) {
        List<SaleDTO> saleDTOList = saleService.findAll();
        model.addAttribute("itemList", saleDTOList);

        return "index";
    }

}
