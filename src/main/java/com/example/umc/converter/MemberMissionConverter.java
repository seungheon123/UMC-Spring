package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResponseDto.MemberMissionPreviewListDto toMemberMissionPreviewListDto(Page<MemberMission> missionList){
        List<MemberMissionResponseDto.MemberMissionPreviewDto> list = missionList.stream()
                .map(mission -> MemberMissionResponseDto.MemberMissionPreviewDto.builder()
                        .id(mission.getId())
                        .title(mission.getMission().getTitle())
                        .storeName(mission.getMission().getStore().getName())
                        .body(mission.getMission().getContent())
                        .point(mission.getMission().getPoint())
                        .status(mission.getMissionStatus())
                        .createdAt(mission.getCreatedAt().toLocalDate()).build())
                .collect(Collectors.toList());
        return MemberMissionResponseDto.MemberMissionPreviewListDto.builder().missionList(list).build();
    }
}
