package com.example.umc.converter;

import com.example.umc.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDto toTempTestDto(){
        return TempResponse.TempTestDto.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDto toTempExceptionDto(Integer flag){
        return TempResponse.TempExceptionDto.builder()
                .flag(flag)
                .build();
    }
}
