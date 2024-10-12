package com.example.demoPostgresU.model;


import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "Customer")
@Table(name = "customer")
@Getter
@NoArgsConstructor
public class Customer {
	@Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
	private Long id;
	
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column
    private String address;
    
    @OneToMany(
            orphanRemoval = true,
            mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Order> orders;


}
