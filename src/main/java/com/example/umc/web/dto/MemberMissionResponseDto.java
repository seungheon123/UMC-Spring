package com.example.umc.web.dto;

import com.example.umc.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionResultDto{
        Long MemberMissionId;
        MissionStatus missionStatus;
        LocalDateTime createdAt;
    }
}
