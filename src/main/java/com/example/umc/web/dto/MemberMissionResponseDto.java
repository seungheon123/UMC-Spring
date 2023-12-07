package com.example.umc.web.dto;

import com.example.umc.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewListDto{
        List<MemberMissionPreviewDto> missionList;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewDto{
        Long id;
        String storeName;
        String title;
        String body;
        Integer point;
        MissionStatus status;
        LocalDate createdAt;
    }
}
