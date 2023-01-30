package com.its.trade.controller;

import com.its.trade.DTO.WishDTO;
import com.its.trade.service.SaleService;
import com.its.trade.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class WishController {
    private final WishService wishService;
    private final SaleService saleService;

    @GetMapping("/wish/list")
    public String wishForm() {

        return "wish_index";
    }

    @PostMapping("/wish/list")
    public @ResponseBody int wish (@ModelAttribute WishDTO wishDTO) {
        int result = wishService.addWish(wishDTO);

        return result;
    }
}
