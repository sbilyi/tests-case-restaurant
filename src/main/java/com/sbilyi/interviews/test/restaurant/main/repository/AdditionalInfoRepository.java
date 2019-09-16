package com.sbilyi.interviews.test.restaurant.main.repository;

import com.sbilyi.interviews.test.restaurant.main.entity.AdditionalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdditionalInfoRepository extends JpaRepository<AdditionalInfoEntity, Long> {
    Optional<AdditionalInfoEntity> findByTitle(String title);
}
