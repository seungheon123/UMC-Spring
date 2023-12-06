package com.example.umc.service.MemberMissionService;

import com.example.umc.domain.mapping.MemberMission;

public interface MemberMissionCommandService {
    MemberMission registerMemberMission(Long memberId, Long missionId);
    Boolean checkIfChallenging(Long id);
}
