package com.its.trade.controller;

import com.its.trade.DTO.UserDTO;
import com.its.trade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/save")
    public String saveForm() {
        return "User/user_save";
    }

    @PostMapping("/user/save")
    public String userSave(@ModelAttribute UserDTO userDTO) throws IOException {
        userService.save(userDTO);

        return "index";
    }

    @PostMapping("/user/save/nameCheck")
    public ResponseEntity nameCheck(@RequestParam("inputName") String userName) {
        String result = userService.duplicateCheck(userName);

        if (result != null) {
            return new ResponseEntity<>("사용가능", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("사용불가", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/user/login")
    public String loginForm() {
        return "User/user_login";
    }

    @PostMapping("/user/login")
    public String userLogin(@ModelAttribute UserDTO userDTO,
                            HttpSession session,
                            Model model) {
        UserDTO result = userService.login(userDTO);

        if (result != null) {
            session.setAttribute("login", result);
            model.addAttribute("login", result);
            return "redirect:/";
        } else {
            return "User/user_login";
        }
    }

    @GetMapping("/user/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
