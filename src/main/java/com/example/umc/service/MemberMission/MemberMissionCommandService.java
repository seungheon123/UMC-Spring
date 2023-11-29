package com.example.umc.service.MemberMission;

import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.web.dto.MemberMissionRequestDto;

public interface MemberMissionCommandService {
    MemberMission registerMemberMission(MemberMissionRequestDto.MemberMissionRegisterDto request);
}
