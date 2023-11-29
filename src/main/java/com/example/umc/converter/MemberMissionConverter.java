package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionResponseDto;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .missionStatus(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberMissionResponseDto.MemberMissionResultDto toMemberMissionResultDto(MemberMission memberMission){
        return MemberMissionResponseDto.MemberMissionResultDto.builder()
                .MemberMissionId(memberMission.getId())
                .missionStatus(memberMission.getMissionStatus())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
