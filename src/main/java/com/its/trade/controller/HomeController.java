package com.its.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

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

    @GetMapping("/sales/armor/helmet")
    public String armor_helmet_form() {
        return "Armor/armor_helmet";
    }

    @GetMapping("/sales/armor/top")
    public String armor_top_form() {
        return "Armor/armor_top";
    }

    @GetMapping("/sales/armor/pants")
    public String armor_pants_form() {
        return "Armor/armor_pants";
    }

    @GetMapping("/sales/armor/gloves")
    public String armor_gloves_form() {
        return "Armor/armor_gloves";
    }

    @GetMapping("/sales/armor/cape")
    public String armor_cape_form() {
        return "Armor/armor_cape";
    }

    @GetMapping("/sales/armor/shoes")
    public String armor_shoes_form() {
        return "Armor/armor_shoes";
    }

    @GetMapping("/sales/weapon/sword")
    public String weapon_sword_form() {
        return "Weapon/weapon_sword";
    }

    @GetMapping("/sales/weapon/bow")
    public String weapon_bow_form() {
        return "Weapon/weapon_bow";
    }

    @GetMapping("/sales/weapon/wand")
    public String weapon_wand_form() {
        return "Weapon/weapon_wand";
    }

    @GetMapping("/sales/weapon/armband")
    public String weapon_armband_form() {
        return "Weapon/weapon_armband";
    }

    @GetMapping("/sales/weapon/knuckle")
    public String weapon_knuckle_form() {
        return "Weapon/weapon_knuckle";
    }

    @GetMapping("/sales/accessory/earring")
    public String accessory_earring_form() {
        return "Accessory/accessory_earring";
    }

    @GetMapping("/sales/accessory/ring")
    public String accessory_ring_form() {
        return "Accessory/accessory_ring";
    }

    @GetMapping("/sales/accessory/pendant")
    public String accessory_pendant_form() {
        return "Accessory/accessory_pendant";
    }

    @GetMapping("/sales/accessory/belt")
    public String accessory_belt_form() {
        return "Accessory/accessory_belt";
    }

}
