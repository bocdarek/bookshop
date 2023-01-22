package com.dariuszboc.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookshopController {

    @GetMapping("/")
    public String showBookshop() {
        return "index";
    }

    @GetMapping("/adminPanel")
    public String showAdminPanel() {
        return "admin-panel";
    }
}
