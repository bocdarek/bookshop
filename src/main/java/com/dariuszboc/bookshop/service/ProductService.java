package com.dariuszboc.bookshop.service;

import com.dariuszboc.bookshop.entity.Category;
import com.dariuszboc.bookshop.entity.Product;
import com.dariuszboc.bookshop.DTO.ProductDTO;
import com.dariuszboc.bookshop.repository.CategoryRepository;
import com.dariuszboc.bookshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product.setAuthor(productDTO.getAuthor());
        product.setTitle(productDTO.getTitle());
        product.setYearOfRelease(product.getYearOfRelease());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        Category category = categoryRepository.findById(productDTO.getCategoryId()).get();
        product.setCategory(category);
        product.setDescription(productDTO.getDescription());
        product.setPublisher(productDTO.getPublisher());
        productRepository.save(product);
    }

    public ProductDTO findById(Long id) {
        Product product =  productRepository.findById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setAuthor(product.getAuthor());
        productDTO.setTitle(product.getTitle());
        productDTO.setPublisher(product.getPublisher());
        productDTO.setDescription(product.getDescription());
        productDTO.setYearOfRelease(product.getYearOfRelease());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}