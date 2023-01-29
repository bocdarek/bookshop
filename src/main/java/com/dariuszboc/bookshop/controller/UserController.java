package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.DTO.ProductDTO;
import com.dariuszboc.bookshop.DTO.UserDTO;
import com.dariuszboc.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String userList(Model model) {
        List<UserDTO> usersDTO = userService.findAll();
        model.addAttribute("usersDTO", usersDTO);
        return "account/user-list";
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

    @GetMapping("/users/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/users/details")
    public String createAccountForm(@RequestParam Long id, Model model) {
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("userDTO", userDTO);
        return "account/user-details";
    }
}
