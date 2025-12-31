package com.swg.model;


import jakarta.persistence.*;
import lombok.*;

//Category entity representing product categories in the system(Model for Category)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Store store;



}
