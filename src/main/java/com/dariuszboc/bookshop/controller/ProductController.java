package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.DTO.CategoryDTO;
import com.dariuszboc.bookshop.DTO.ProductDTO;
import com.dariuszboc.bookshop.service.CategoryService;
import com.dariuszboc.bookshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String productList(Model model) {
        List<ProductDTO> productsDTO = productService.findAll();
        model.addAttribute("productsDTO", productsDTO);
        return "products/product-list";
    }

    @GetMapping("/products/addProductForm")
    public String addProductForm(Model model) {
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO", productDTO);
        List<CategoryDTO> categoriesDTO = categoryService.findAll();
        model.addAttribute("categoriesDTO", categoriesDTO);
        return "products/add-product-form";
    }

    @PostMapping("/products/saveProduct")
    public String saveProduct(@ModelAttribute ProductDTO productDTO) {
        productService.save(productDTO);
        return "redirect:/products";
    }

    @GetMapping("/products/showUpdateForm")
    public String showUpdateForm(@RequestParam Long id, Model model) {
        ProductDTO productDTO = productService.findById(id);
        model.addAttribute("productDTO", productDTO);
        List<CategoryDTO> categoriesDTO = categoryService.findAll();
        model.addAttribute("categoriesDTO", categoriesDTO);
        return "products/add-product-form";
    }

    @GetMapping("/products/deleteProduct")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
