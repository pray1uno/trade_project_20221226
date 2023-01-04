package com.its.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/category/armor")
    public String armor() {
        return "Item/item_armor";
    }

    @GetMapping("/category/weapon")
    public String weapon() {
        return "Item/item_weapon";
    }

    @GetMapping("/category/accessory")
    public String accessory() {
        return "Item/item_accessory";
    }

}
