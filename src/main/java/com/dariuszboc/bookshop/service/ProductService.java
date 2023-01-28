package com.dariuszboc.bookshop.service;

import com.dariuszboc.bookshop.DTO.CategoryDTO;
import com.dariuszboc.bookshop.entity.Category;
import com.dariuszboc.bookshop.entity.Product;
import com.dariuszboc.bookshop.DTO.ProductDTO;
import com.dariuszboc.bookshop.repository.CategoryRepository;
import com.dariuszboc.bookshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return getDtoListFromProductList(products);
    }

    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setAuthor(productDTO.getAuthor());
        product.setTitle(productDTO.getTitle());
        product.setYearOfRelease(productDTO.getYearOfRelease());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setPublisher(productDTO.getPublisher());
        product.setImageURL(productDTO.getImageURL());
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
        productDTO.setImageURL(product.getImageURL());
        productDTO.setCategory(product.getCategory());
        return productDTO;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> findByCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryDTO.getId()).get();
        List<Product> products = productRepository.findByCategory(category);
        return getDtoListFromProductList(products);
    }

    private List<ProductDTO> getDtoListFromProductList(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        products.forEach(product -> {
            Long id = product.getId();
            ProductDTO productDTO = this.findById(id);
            productsDTO.add(productDTO);
        });
        return productsDTO;
    }
}
