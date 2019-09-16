package com.sbilyi.interviews.test.restaurant.main.service;

import com.sbilyi.interviews.test.restaurant.main.entity.AdditionalInfoEntity;
import com.sbilyi.interviews.test.restaurant.main.payload.AdditionalInfo;
import com.sbilyi.interviews.test.restaurant.main.repository.AdditionalInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.Opt;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuItemAdditionalInfoServiceServiceImpl implements MenuItemAdditionalInfoServiceService {

    @Autowired
    private AdditionalInfoRepository repository;
    @Autowired
    private MappingService mapper;

    @Override
    public List<AdditionalInfo> get() {
        return repository.findAll().stream().map(mapper::convert).collect(Collectors.toList());
    }

    @Override
    public Optional<AdditionalInfo> get(Long id) {
        Optional<AdditionalInfoEntity> menuItemEntity = repository.findById(id);
        return Optional.ofNullable(menuItemEntity.map(itemEntity -> mapper.convert(itemEntity)).orElse(null));
    }

    @Override
    public AdditionalInfo save(AdditionalInfo info) {
        return mapper.convert(repository.save(mapper.convert(info)));
    }

    @Override
    @NotNull
    public Set<AdditionalInfoEntity> mergeAdditionalInfoEntities(List<AdditionalInfo> additionalInfoList) {
        Set<AdditionalInfoEntity> additionalInfos = new HashSet<>();
        for (AdditionalInfo info : additionalInfoList) {
            Optional<AdditionalInfoEntity> existedAdditinalInfo = info.getId() == null ? info.getTitle() == null ? Optional.empty() : repository.findByTitle(info.getTitle()) : repository.findById(info.getId());
            if (existedAdditinalInfo.isPresent()) {
                if (Objects.equals(existedAdditinalInfo.get().getId(), info.getId()) &&
                        Objects.equals(existedAdditinalInfo.get().getTitle(), info.getTitle()) ) {
                    additionalInfos.add(existedAdditinalInfo.get());
                } else if (Objects.equals(existedAdditinalInfo.get().getId(), info.getId())) {
                    info.setId(null);
                    AdditionalInfoEntity savedEntity = repository.save(mapper.convert(info));
                    additionalInfos.add(savedEntity);
                } else {
                    additionalInfos.add(existedAdditinalInfo.get());
                }
            } else {
                if (!StringUtils.isEmpty(info.getTitle())) {
                    AdditionalInfoEntity savedEntity = repository.save(mapper.convert(info));
                    additionalInfos.add(savedEntity);
                }
            }
        }
        return additionalInfos;
    }
}
