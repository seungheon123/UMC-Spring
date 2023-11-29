package com.example.umc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionResultDto{
        Long MissionId;
        LocalDateTime createdAt;
    }
}
