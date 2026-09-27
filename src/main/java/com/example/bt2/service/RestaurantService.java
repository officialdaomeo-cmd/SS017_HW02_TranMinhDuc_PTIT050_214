package com.example.bt2.service;

import com.example.bt2.entity.MenuItem;
import com.example.bt2.repository.MenuItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Cacheable(value = "restaurantMenu", key = "#id")
    public List<MenuItem> getMenuByRestaurantId(Long id) {
        logger.info("Truy vấn DB để lấy menu cho restaurantId: {}", id);
        try {
            // Giả lập độ trễ truy vấn database 3 giây
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return menuItemRepository.findByRestaurantId(id);
    }
}
