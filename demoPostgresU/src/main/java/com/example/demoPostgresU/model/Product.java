package com.example.demoPostgresU.model;


import lombok.*;
import jakarta.persistence.*;

@Table(name = "product")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
public class Product {
	
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column
    private String text;
    
    @OneToOne(
            mappedBy = "product",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private OrderItem orderItem;


}
