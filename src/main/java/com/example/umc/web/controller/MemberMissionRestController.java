package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.service.MemberMission.MemberMissionCommandService;
import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.validation.annotation.ExistMission;
import com.example.umc.validation.annotation.VerifiedMissionChallenge;
import com.example.umc.web.dto.MemberMissionRequestDto;
import com.example.umc.web.dto.MemberMissionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Validated
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/member/{memberId}/mission/{missionId}")
    public ApiResponse<MemberMissionResponseDto.MemberMissionResultDto> register(
            @ExistMember @RequestParam("memberId") Long memberId,
            @ExistMission @RequestParam("missionId") Long missionId
    ){
        MemberMission memberMission = memberMissionCommandService.registerMemberMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDto(memberMission));
    }
}
