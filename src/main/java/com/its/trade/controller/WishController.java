package com.its.trade.controller;

import com.its.trade.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WishController {
    private final WishService wishService;
}
