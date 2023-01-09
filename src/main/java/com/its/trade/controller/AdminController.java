package com.its.trade.controller;

import com.its.trade.DTO.UserDTO;
import com.its.trade.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin")
    public String adminIndex() {
        return "admin_index";
    }

    @GetMapping("/admin/user")
    public String findAll(Model model) {
        List<UserDTO> userDTOList = adminService.findAll();
        model.addAttribute("userList", userDTOList);
        return "Admin/admin_user";
    }

    @DeleteMapping("/admin/user/delete/{id}")
    public ResponseEntity userDelete(@PathVariable Long id) {
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/user/withdraw")
    public String withdraw(@RequestParam Long id) {
        adminService.withdraw(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/give")
    public String give(@RequestParam Long id) {
        adminService.give(id);
        return "redirect:/admin/user";
    }
}
