package com.example.umc.web.dto;

import com.example.umc.apiPayload.validation.annotation.ExistMember;
import com.example.umc.apiPayload.validation.annotation.VerifiedMissionChallenge;
import lombok.Getter;

public class MemberMissionRequestDto {
    @Getter
    public static class MemberMissionRegisterDto{
        @ExistMember
        Long memberId;

        @VerifiedMissionChallenge
        Long missionId;
    }
}
