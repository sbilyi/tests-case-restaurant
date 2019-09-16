package com.sbilyi.interviews.test.restaurant.main.service;

import com.sbilyi.interviews.test.restaurant.main.entity.MenuItemEntity;
import com.sbilyi.interviews.test.restaurant.main.payload.MenuItem;
import com.sbilyi.interviews.test.restaurant.main.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private MenuItemRepository repository;

    @Autowired
    private MenuItemAdditionalInfoServiceService additionalInfoServiceService;

    @Override
    public MenuItem get(Long id) {
        Optional<MenuItemEntity> menuItemEntity = repository.findById(id);
        return menuItemEntity.map(itemEntity -> mappingService.convert(itemEntity)).orElse(null);
    }

    @Override
    public List<MenuItem> get() {
        return repository.findAll().stream().map(mappingService::convert).collect(Collectors.toList());
    }

    @Override
    public MenuItem update(MenuItem menuItem) {
        return mappingService.convert(repository.save(mappingService.convert(menuItem)));
    }

    @Override
    public MenuItem delete(Long id) {
        final MenuItem menuItem = get(id);
        repository.deleteById(id);
        return menuItem;
    }

    @Override
    @Transactional
    public MenuItem create(MenuItem menuItem) {
        MenuItemEntity entity = mappingService.convert(menuItem);
        entity.setAdditionalInfo(additionalInfoServiceService.mergeAdditionalInfoEntities(menuItem.getAdditionalInfo()));
        return mappingService.convert(repository.save(entity));
    }



}
