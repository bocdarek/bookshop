package com.dariuszboc.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    @GetMapping("/navbar")
    public String getNavbar() {
        return "fragments/navbar";
    }
}
