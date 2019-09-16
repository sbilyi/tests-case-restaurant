package com.sbilyi.interviews.test.restaurant.main.controller;

import com.sbilyi.interviews.test.restaurant.main.Paths;
import com.sbilyi.interviews.test.restaurant.main.payload.AdditionalInfo;
import com.sbilyi.interviews.test.restaurant.main.service.MenuItemAdditionalInfoServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdditionalInfoController {

    private static final String PATH = "/menu_item_additional_info";

    @Autowired
    private MenuItemAdditionalInfoServiceService menuItemAdditionalInfoServiceService;

    @RequestMapping(value = Paths.API_PATH + PATH, method = RequestMethod.GET)
    public List<AdditionalInfo> getAll() {
        return menuItemAdditionalInfoServiceService.get();
    }

}
