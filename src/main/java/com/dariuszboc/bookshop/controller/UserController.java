package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.DTO.UserDTO;
import com.dariuszboc.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/myAccount")
    public String showMyAccount() {
        return "account/my-account";
    }

    @GetMapping("/createAccount")
    public String createAccountForm(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        return "account/create-account-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserDTO userDTO) {
        userService.saveWithNewPassword(userDTO);
        return "redirect:/index";
    }
}
