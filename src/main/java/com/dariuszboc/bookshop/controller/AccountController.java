package com.dariuszboc.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/createAccount")
    public String createAccountForm() {
        return "account/create-account-form";
    }

    @GetMapping("/myAccount")
    public String showMyAccount() {
        return "account/my-account";
    }


}
