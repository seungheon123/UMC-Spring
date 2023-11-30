package com.example.umc.service.StoreService;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.exception.handler.RegionHandler;
import com.example.umc.converter.StoreConverter;
import com.example.umc.domain.Region;
import com.example.umc.domain.Store;
import com.example.umc.repository.RegionRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.StoreRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    @Override
    @Transactional
    public Store registerStore(StoreRequestDto.StoreRegisterDto request){
        Region region = regionRepository.findRegionByName(request.getRegion())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store newStore = StoreConverter.toStore(request,region);
        return storeRepository.save(newStore);
    }
}
