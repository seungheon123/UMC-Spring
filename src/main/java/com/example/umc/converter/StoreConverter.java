package com.example.umc.converter;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Region;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.StoreRequestDto;
import com.example.umc.web.dto.StoreResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDto.StoreMissionListDto toStoreMissionListDto(Page<Mission> missionList){
        List<StoreResponseDto.StoreMissionDto> list = missionList.stream()
                .map(mission -> StoreResponseDto.StoreMissionDto.builder()
                        .title(mission.getTitle())
                        .body(mission.getContent())
                        .point(mission.getPoint())
                        .createdAt(mission.getCreatedAt().toLocalDate()).build())
                .collect(Collectors.toList());
        return StoreResponseDto.StoreMissionListDto.builder().missionList(list).build();
    }


}
