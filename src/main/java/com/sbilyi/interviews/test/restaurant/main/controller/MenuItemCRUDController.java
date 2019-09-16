package com.sbilyi.interviews.test.restaurant.main.controller;

import com.sbilyi.interviews.test.restaurant.main.Paths;
import com.sbilyi.interviews.test.restaurant.main.payload.MenuItem;
import com.sbilyi.interviews.test.restaurant.main.service.MenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemCRUDController {

    private static final String PATH = "/menu_item";

    @Autowired
    private MenuItemServiceImpl menuItemService;

    @RequestMapping(value = Paths.API_PATH + PATH + "/{id}", method = RequestMethod.GET)
    public MenuItem get(@PathVariable("id") Long id) {
        return menuItemService.get(id);
    }

    @RequestMapping(value = Paths.API_PATH + PATH, method = RequestMethod.GET)
    public List<MenuItem> getAll() {
        return menuItemService.get();
    }

    @RequestMapping(value = Paths.API_PATH + PATH + "/{id}", method = RequestMethod.PUT)
    public MenuItem update(@RequestBody MenuItem menuItem) {
        return menuItemService.update(menuItem);
    }

    @RequestMapping(value = Paths.API_PATH + PATH + "/{id}", method = RequestMethod.DELETE)
    public MenuItem delete(@PathVariable("id") Long id) {
        return menuItemService.delete(id);
    }

    @RequestMapping(value = Paths.API_PATH + PATH, method = RequestMethod.POST)
    public MenuItem create(@RequestBody MenuItem menuItem) {
        return menuItemService.create(menuItem);
    }


}
