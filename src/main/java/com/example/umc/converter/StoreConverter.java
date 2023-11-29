package com.example.umc.converter;

import com.example.umc.domain.Region;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.StoreRequestDto;
import com.example.umc.web.dto.StoreResponseDto;

public class StoreConverter {

    public static Store toStore(StoreRequestDto.StoreRegisterDto request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();

    }

    public static StoreResponseDto.RegisterResultDto toRegisterResultDto(Store store){
        return StoreResponseDto.RegisterResultDto.builder()
                .StoreId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

}
