package com.example.bt2.controller;

import com.example.bt2.entity.MenuItem;
import com.example.bt2.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<List<MenuItem>> getMenu(@PathVariable Long restaurantId) {
        List<MenuItem> menu = restaurantService.getMenuByRestaurantId(restaurantId);
        return ResponseEntity.ok(menu);
    }
}
