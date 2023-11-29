package com.example.umc.web.dto;

import com.example.umc.validation.annotation.ExistRegions;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class StoreRequestDto {

    @Getter
    public static class StoreRegisterDto{
        @NotBlank
        String name;

        @NotBlank
        String address;

        @ExistRegions
        String region;
    }
}
