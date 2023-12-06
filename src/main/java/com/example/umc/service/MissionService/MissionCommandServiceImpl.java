package com.example.umc.service.MissionService;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.exception.handler.StoreHandler;
import com.example.umc.converter.MissionConverter;
import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.repository.MissionRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.MissionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission registerMission(MissionRequestDto.MissionRegisterDto request, Long StoreId) {
        Store store = storeRepository.findById(StoreId)
                .orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }

    @Override
    public Boolean existMission(Long missionId) {
        return missionRepository.existsById(missionId);
    }
}
