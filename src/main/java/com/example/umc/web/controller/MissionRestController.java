package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MissionConverter;
import com.example.umc.domain.Mission;
import com.example.umc.service.MissionService.MissionCommandService;
import com.example.umc.web.dto.MissionRequestDto;
import com.example.umc.web.dto.MissionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDto.MissionResultDto> register(@PathVariable ("storeId") Long id, @RequestBody @Valid MissionRequestDto.MissionRegisterDto request){
        Mission mission = missionCommandService.registerMission(request, id);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDto(mission));
    }
}
