package com.dariuszboc.bookshop.repository;

import com.dariuszboc.bookshop.entity.Category;
import com.dariuszboc.bookshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

}
