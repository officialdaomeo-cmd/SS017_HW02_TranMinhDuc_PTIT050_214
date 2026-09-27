package com.example.bt2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "menu_items")
@Data
public class MenuItem implements Serializable {
    @Id
    private Long id;
    private Long restaurantId;
    private String dishName;
    private Double price;
}
