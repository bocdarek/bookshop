package com.dariuszboc.bookshop.controller;

import com.dariuszboc.bookshop.entity.Product;
import com.dariuszboc.bookshop.DTO.ProductDTO;
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

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/products")
    public String productList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products/product-list";
    }

    @GetMapping("/products/addProductForm")
    public String addProductForm(Model model) {
        ProductDTO product = new ProductDTO();
        model.addAttribute("product", product);
        return "products/add-product-form";
    }

    @PostMapping("/products/saveProduct")
    public String saveProduct(@ModelAttribute ProductDTO product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/showUpdateForm")
    public String showUpdateForm(@RequestParam Long id, Model model) {
        ProductDTO productDTO = productService.findById(id);
        model.addAttribute("productDTO", productDTO);
        return "products/add-product-form";
    }

    @GetMapping("/products/deleteProduct")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
