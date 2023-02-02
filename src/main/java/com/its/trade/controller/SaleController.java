package com.its.trade.controller;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String findAll(Model model,
                          @PageableDefault(page = 1) Pageable pageable) {
        Page<SaleDTO> saleDTOPage = saleService.paging(pageable);
        model.addAttribute("paging", saleDTOPage);

        int blockLimit = 5;
        int startPage = (((int) (Math.ceil((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = ((startPage + blockLimit - 1) < saleDTOPage.getTotalPages()) ? startPage + blockLimit - 1 : saleDTOPage.getTotalPages();

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

//        List<SaleDTO> saleDTOList = saleService.findAll();
//        model.addAttribute("itemList", saleDTOList);

        return "index";
    }

    @GetMapping("/item/{id}")
    public String findById(@PathVariable Long id,
                           Model model) {
        saleService.updateHits(id);
        SaleDTO saleDTO = saleService.findById(id);
        model.addAttribute("findById", saleDTO);

        return "Item/item_detail";

    }

}
