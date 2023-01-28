package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.DTO.CategoryDTO;
import com.dariuszboc.bookshop.DTO.ProductDTO;
import com.dariuszboc.bookshop.service.CategoryService;
import com.dariuszboc.bookshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookshopController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public BookshopController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = {"", "/", "index"})
    public String showBookshop(Model model) {
        List<ProductDTO> productsDTO = productService.findAll();
        model.addAttribute("productsDTO", productsDTO);
        List<CategoryDTO> categoriesDTO = categoryService.findAll();
        model.addAttribute("categoriesDTO", categoriesDTO);
        return "index";
    }

    @GetMapping("/adminPanel")
    public String showAdminPanel() {
        return "admin-panel";
    }

    @GetMapping("/index/{id}")
    public String showBookshopFilteredByCategory(@PathVariable Long id, Model model) {
        CategoryDTO categoryDTO = categoryService.findById(id);
        List<ProductDTO> productsDTO = productService.findByCategory(categoryDTO);
        model.addAttribute("productsDTO", productsDTO);
        List<CategoryDTO> categoriesDTO = categoryService.findAll();
        model.addAttribute("categoriesDTO", categoriesDTO);
        return "index";
    }
}
