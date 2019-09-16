package com.sbilyi.interviews.test.restaurant.main.service;

import com.sbilyi.interviews.test.restaurant.main.entity.AdditionalInfoEntity;
import com.sbilyi.interviews.test.restaurant.main.payload.AdditionalInfo;
import com.sbilyi.interviews.test.restaurant.main.payload.MenuItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MenuItemAdditionalInfoServiceService {
    List<AdditionalInfo> get();

    Optional<AdditionalInfo> get(Long id);

    AdditionalInfo save(AdditionalInfo info);

    @NotNull
    Set<AdditionalInfoEntity> mergeAdditionalInfoEntities(List<AdditionalInfo> additionalInfoList);
}
