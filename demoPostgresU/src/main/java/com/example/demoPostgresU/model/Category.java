package com.example.demoPostgresU.model;


import lombok.*;
import jakarta.persistence.*;

@Entity(name = "Category")
@Table(name = "category")
@NoArgsConstructor
@Getter
public class Category {
	
	@Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;


}
