package com.dariuszboc.bookshop.DTO;

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

    private String ImageURL;

    private Long categoryId;

}
