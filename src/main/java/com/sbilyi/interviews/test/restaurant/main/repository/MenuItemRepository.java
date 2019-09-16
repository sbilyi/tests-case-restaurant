package com.sbilyi.interviews.test.restaurant.main.repository;

import com.sbilyi.interviews.test.restaurant.main.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {
}
