package com.sbilyi.interviews.test.restaurant.main.config;

import com.sbilyi.interviews.test.restaurant.main.service.MenuItemService;
import com.sbilyi.interviews.test.restaurant.main.service.MenuItemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public MenuItemService gameService() {
        return new MenuItemServiceImpl();
    }

}
