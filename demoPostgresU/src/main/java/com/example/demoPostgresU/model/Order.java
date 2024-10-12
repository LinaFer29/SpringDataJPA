package com.example.demoPostgresU.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;

@Table(name = "order_table")
@Entity(name = "Order")
@NoArgsConstructor
@Getter
public class Order {
	
	@Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column
    private Long id;

    @Column( nullable = false)
    private int totalPrice;
    
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "order_customer_fk"
            )
    )
    private Customer customer;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    @CreatedDate
    private LocalDateTime createdAt;
    
    @OneToMany(
            orphanRemoval = true,
            mappedBy = "order",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<OrderItem> orderItems;




}
