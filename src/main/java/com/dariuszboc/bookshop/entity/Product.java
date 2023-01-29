package com.dariuszboc.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer yearOfRelease;

    private Double price;

    private Integer quantity;

    private String description;

    private String Publisher;

    private String imageURL;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy="product")
    private Set<CartItem> cartItems;

}
