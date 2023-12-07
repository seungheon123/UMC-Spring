package com.example.umc.service.MemberMissionService;

import com.example.umc.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

public interface MemberMissionCommandService {
    MemberMission registerMemberMission(Long memberId, Long missionId);
    Boolean checkIfChallenging(Long id);
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);

    MemberMission updateMemberMissionStatus(Long memberMissionId);
}
