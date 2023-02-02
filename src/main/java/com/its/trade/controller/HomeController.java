package com.its.trade.controller;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SaleService saleService;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/category/armor")
    public String armor(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmor();
        model.addAttribute("armorList", saleDTOList);
        return "Item/item_armor";
    }

    @GetMapping("/category/weapon")
    public String weapon(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByWeapon();
        model.addAttribute("weaponList", saleDTOList);
        return "Item/item_weapon";
    }

    @GetMapping("/category/accessory")
    public String accessory(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByAccessory();
        model.addAttribute("accessoryList", saleDTOList);
        return "Item/item_accessory";
    }

    @GetMapping("/sales/armor/helmet")
    public String armor_helmet_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmorHelmet();
        model.addAttribute("helmet", saleDTOList);
        return "Armor/armor_helmet";
    }

    @GetMapping("/sales/armor/top")
    public String armor_top_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmorTop();
        model.addAttribute("top", saleDTOList);
        return "Armor/armor_top";
    }

    @GetMapping("/sales/armor/pants")
    public String armor_pants_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmorPants();
        model.addAttribute("pants", saleDTOList);
        return "Armor/armor_pants";
    }

    @GetMapping("/sales/armor/gloves")
    public String armor_gloves_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmorGloves();
        model.addAttribute("gloves", saleDTOList);
        return "Armor/armor_gloves";
    }

    @GetMapping("/sales/armor/cape")
    public String armor_cape_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmorCape();
        model.addAttribute("cape", saleDTOList);
        return "Armor/armor_cape";
    }

    @GetMapping("/sales/armor/shoes")
    public String armor_shoes_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByArmorShoes();
        model.addAttribute("shoes", saleDTOList);
        return "Armor/armor_shoes";
    }

    @GetMapping("/sales/weapon/sword")
    public String weapon_sword_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByWeaponSword();
        model.addAttribute("sword", saleDTOList);
        return "Weapon/weapon_sword";
    }

    @GetMapping("/sales/weapon/bow")
    public String weapon_bow_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByWeaponBow();
        model.addAttribute("bow", saleDTOList);
        return "Weapon/weapon_bow";
    }

    @GetMapping("/sales/weapon/wand")
    public String weapon_wand_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByWeaponWand();
        model.addAttribute("wand", saleDTOList);
        return "Weapon/weapon_wand";
    }

    @GetMapping("/sales/weapon/armband")
    public String weapon_armband_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByWeaponArmband();
        model.addAttribute("armband", saleDTOList);
        return "Weapon/weapon_armband";
    }

    @GetMapping("/sales/weapon/knuckle")
    public String weapon_knuckle_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByWeaponKnuckle();
        model.addAttribute("knuckle", saleDTOList);
        return "Weapon/weapon_knuckle";
    }

    @GetMapping("/sales/accessory/earring")
    public String accessory_earring_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByAccessoryEarring();
        model.addAttribute("earring", saleDTOList);
        return "Accessory/accessory_earring";
    }

    @GetMapping("/sales/accessory/ring")
    public String accessory_ring_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByAccessoryRing();
        model.addAttribute("ring", saleDTOList);
        return "Accessory/accessory_ring";
    }

    @GetMapping("/sales/accessory/pendant")
    public String accessory_pendant_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByAccessoryPendant();
        model.addAttribute("pendant", saleDTOList);
        return "Accessory/accessory_pendant";
    }

    @GetMapping("/sales/accessory/belt")
    public String accessory_belt_form(Model model) {
        List<SaleDTO> saleDTOList = saleService.findByAccessoryBelt();
        model.addAttribute("belt", saleDTOList);
        return "Accessory/accessory_belt";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam("keyword") String keyword,
//                         Model model) {
//        List<SaleDTO> saleDTOList = saleService.search(keyword);
//        model.addAttribute("search", saleDTOList);
//        return "search_index";
//    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
                         @PageableDefault(page = 1) Pageable pageable,
                         Model model) {
        Page<SaleDTO> searchList = saleService.search(keyword, pageable);
        model.addAttribute("paging", searchList);

        model.addAttribute("keyword", keyword);

        int blockLimit = 5;
        int startPage = (((int) (Math.ceil((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = ((startPage + blockLimit - 1) < searchList.getTotalPages()) ? startPage + blockLimit - 1 : searchList.getTotalPages();

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "search_index";
    }
}
