package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.service.MemberMissionService.MemberMissionCommandService;
import com.example.umc.validation.annotation.CheckPage;
import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.validation.annotation.ExistMission;
import com.example.umc.validation.annotation.VerifiedMissionChallenge;
import com.example.umc.web.dto.MemberMissionResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Validated
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/member/{memberId}/mission/{missionId}")
    public ApiResponse<MemberMissionResponseDto.MemberMissionResultDto> register(
            @ExistMember @PathVariable Long memberId,
            @ExistMission @PathVariable Long missionId){
        System.out.println(missionId);
        MemberMission memberMission = memberMissionCommandService.registerMemberMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDto(memberMission));
    }

    @Operation(summary = "내가 진행중인 미션 목록")
    @Parameters({
            @Parameter(name = "memberId",description = "회원의 Id, Path Variable입니다"),
            @Parameter(name = "page",description = "페이지 번호, 0번이 1 페이지입니다"),
    })
    @GetMapping("/member/{memberId}/missions")
    public ApiResponse<MemberMissionResponseDto.MemberMissionPreviewListDto> getMemberMissionList(
            @ExistMember @PathVariable Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page
    ){
        Page<MemberMission> memberMissionList = memberMissionCommandService.getMemberMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionPreviewListDto(memberMissionList));
    }

    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기")
    @Parameters({
            @Parameter(name = "memberId",description = "회원의 Id, Path Variable입니다"),
            @Parameter(name = "id",description = "회원이 진행중인 미션(memberMission)의 Id입니다")
    })
    @PatchMapping("/member/{memberId}/member-mission")
    public ApiResponse<MemberMissionResponseDto.MemberMissionResultDto> patchMemberMissionStatus(
        @ExistMember @PathVariable(name = "memberId") Long memberId,
        @RequestParam(name="id") Long memberMissionId
    ){
        MemberMission memberMission = memberMissionCommandService.updateMemberMissionStatus(memberMissionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDto(memberMission));
    }
}
