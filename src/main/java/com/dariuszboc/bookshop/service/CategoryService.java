package com.dariuszboc.bookshop.service;

import com.dariuszboc.bookshop.DTO.CategoryDTO;
import com.dariuszboc.bookshop.entity.Category;
import com.dariuszboc.bookshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setId(categoryDTO.getId());
        categoryRepository.save(category);
    }

    public CategoryDTO findById(Long id) {
        Category category =  categoryRepository.findById(id).get();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

}
