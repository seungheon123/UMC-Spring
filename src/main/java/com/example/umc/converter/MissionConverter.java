package com.example.umc.converter;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.MissionRequestDto;
import com.example.umc.web.dto.MissionResponseDto;

public class MissionConverter {
    public static Mission toMission(MissionRequestDto.MissionRegisterDto request, Store store){
        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .point(request.getPoint())
                .store(store)
                .build();
    }

    public static MissionResponseDto.MissionResultDto toMissionResultDto(Mission mission){
        return MissionResponseDto.MissionResultDto.builder()
                .MissionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
