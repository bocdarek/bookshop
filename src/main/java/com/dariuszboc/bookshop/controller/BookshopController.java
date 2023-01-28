package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.DTO.ProductDTO;
import com.dariuszboc.bookshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookshopController {

    private final ProductService productService;

    @Autowired
    public BookshopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value={"", "/", "index"})
    public String showBookshop(Model model) {
        List<ProductDTO> productsDTO = productService.findAll();
        model.addAttribute("productsDTO", productsDTO);
        return "index";
    }

    @GetMapping("/adminPanel")
    public String showAdminPanel() {
        return "admin-panel";
    }
}
