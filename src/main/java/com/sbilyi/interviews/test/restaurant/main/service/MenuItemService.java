package com.sbilyi.interviews.test.restaurant.main.service;

import com.sbilyi.interviews.test.restaurant.main.payload.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem get(Long id);

    List<MenuItem> get();

    MenuItem update(MenuItem menuItem);

    MenuItem delete(Long id);

    MenuItem create(MenuItem menuItem);
}
