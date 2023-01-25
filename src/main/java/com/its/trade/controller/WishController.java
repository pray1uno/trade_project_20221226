package com.its.trade.controller;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.DTO.WishDTO;
import com.its.trade.service.SaleService;
import com.its.trade.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public @ResponseBody boolean wishList(@ModelAttribute WishDTO wishDTO) {
        if (wishService.check(wishDTO)) {
            wishService.save(wishDTO);
            return true;
        } else {
            return false;
        }

    }


}
