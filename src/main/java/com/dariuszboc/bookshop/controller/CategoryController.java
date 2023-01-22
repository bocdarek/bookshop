package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.DTO.CategoryDTO;
import com.dariuszboc.bookshop.entity.Category;
import com.dariuszboc.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String categoryList(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/category-list";
    }

    @GetMapping("/categories/addCategoryForm")
    public String addCategoryForm(Model model) {
        CategoryDTO categoryDTO = new CategoryDTO();
        model.addAttribute("categoryDTO", categoryDTO);
        return "categories/add-category-form";
    }

    @PostMapping("/categories/saveCategory")
    public String saveCategory(@ModelAttribute CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
        return "redirect:/categories";
    }

    @GetMapping("/categories/showUpdateForm")
    public String showUpdateForm(@RequestParam Long id, Model model) {
        CategoryDTO categoryDTO = categoryService.findById(id);
        model.addAttribute("categoryDTO", categoryDTO);
        return "categories/add-category-form";
    }

    @GetMapping("/categories/deleteCategory")
    public String deleteCategory(@RequestParam Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
}
