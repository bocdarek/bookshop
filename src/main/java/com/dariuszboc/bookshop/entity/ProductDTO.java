package com.dariuszboc.bookshop.entity;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String title;

    private String author;

    private Integer yearOfRelease;

    private Double price;

    private Integer quantity;

    private String description;

    private String Publisher;

    private Long categoryId;
}
