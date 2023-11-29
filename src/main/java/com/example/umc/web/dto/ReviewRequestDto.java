package com.example.umc.web.dto;

import com.example.umc.apiPayload.validation.annotation.ExistMember;
import com.example.umc.apiPayload.validation.annotation.ExistStore;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReviewRequestDto {

    @Getter
    public static class ReviewRegisterDto{
        @ExistMember
        Long memberId;

        @ExistStore
        Long storeId;

        @NotBlank
        String content;

        @Min(value = 0, message = "값은 최소 0 이상이어야 합니다.")
        @Max(value = 5, message = "값은 최대 5 이하여야 합니다.")
        int rating;
    }

}
