package com.example.umc.service.MissionService;

import com.example.umc.domain.Mission;
import com.example.umc.web.dto.MissionRequestDto;

public interface MissionCommandService {
    Mission registerMission(MissionRequestDto.MissionRegisterDto request, Long StoreId);
}
