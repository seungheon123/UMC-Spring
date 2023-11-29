package com.example.umc.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MissionRequestDto {
    @Getter
    public static class MissionRegisterDto{
        @Size(max = 45)
        String title;

        @NotBlank
        String content;

        @NotNull
        @Min(value = 1, message = "포인트는 1 이상이어야 합니다.")
        int point;
    }

}
