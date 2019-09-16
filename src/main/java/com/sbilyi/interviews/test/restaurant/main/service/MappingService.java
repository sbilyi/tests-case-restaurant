package com.sbilyi.interviews.test.restaurant.main.service;

import com.sbilyi.interviews.test.restaurant.main.entity.AdditionalInfoEntity;
import com.sbilyi.interviews.test.restaurant.main.entity.MenuItemEntity;
import com.sbilyi.interviews.test.restaurant.main.payload.AdditionalInfo;
import com.sbilyi.interviews.test.restaurant.main.payload.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MappingService {

    private final Function<List<AdditionalInfo>, Set<AdditionalInfoEntity>> infoToEntityConverter = (e) -> e.stream().map(this::convert).collect(Collectors.toSet());
    private final Function<Set<AdditionalInfoEntity>, List<AdditionalInfo>> infoFromEntityConverter = (e) -> e.stream().map(this::convert).collect(Collectors.toList());

    public MenuItemEntity convert(MenuItem menuItem) {

        MenuItemEntity entity = new MenuItemEntity();
        entity.setId(menuItem.getId());
        entity.setTitle(menuItem.getTitle());
        entity.setImage(menuItem.getImage());
        entity.setPrice(menuItem.getPrice());
        entity.setDescription(menuItem.getDescription());
        entity.setAdditionalInfo(infoToEntityConverter.apply(menuItem.getAdditionalInfo()));
        return entity;
    }

    public MenuItem convert(MenuItemEntity entity) {

        MenuItem menuItem = new MenuItem();
        menuItem.setId(entity.getId());
        menuItem.setImage(entity.getImage());
        menuItem.setTitle(entity.getTitle());
        menuItem.setPrice(entity.getPrice());
        menuItem.setDescription(entity.getDescription());
        menuItem.setAdditionalInfo(infoFromEntityConverter.apply(entity.getAdditionalInfo()));

        return menuItem;
    }

    public AdditionalInfo convert(AdditionalInfoEntity additionalInfoEntity) {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setId(additionalInfoEntity.getId());
        additionalInfo.setTitle(additionalInfoEntity.getTitle());
        return additionalInfo;
    }

    public AdditionalInfoEntity convert(AdditionalInfo additionalInfo) {
        AdditionalInfoEntity additionalInfoEntity = new AdditionalInfoEntity();
        additionalInfoEntity.setId(additionalInfo.getId());
        additionalInfoEntity.setTitle(additionalInfo.getTitle());
        return additionalInfoEntity;
    }
}
