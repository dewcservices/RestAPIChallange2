package com.softwareengineeringchallenge.restAPIchallge2.entity;

//local 

//imported
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    // maxsize

    @Column
    private String description;
}
