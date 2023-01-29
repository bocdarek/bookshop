package com.dariuszboc.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String fullName;

    private String address;

    private String email;

    private String phoneNumber;

    private String role;

    @OneToMany(mappedBy="user")
    private Set<CartItem> cartItems;

    @OneToMany(mappedBy="user")
    private Set<Order> orders;

}
