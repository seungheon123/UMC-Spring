package com.example.umc.service.MemberMission;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.exception.handler.MemberHandler;
import com.example.umc.apiPayload.exception.handler.MemberMissionHandler;
import com.example.umc.apiPayload.exception.handler.MissionHandler;
import com.example.umc.converter.MemberMissionConverter;
import com.example.umc.domain.Member;
import com.example.umc.domain.Mission;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import com.example.umc.repository.MemberMissionRepository;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.MissionRepository;
import com.example.umc.web.dto.MemberMissionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    @Override
    public MemberMission registerMemberMission(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Optional<MemberMission> existingMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId);
        existingMission.ifPresent(memberMission -> {
            if (memberMission.getMissionStatus() == MissionStatus.CHALLENGING) {
                throw new MemberMissionHandler(ErrorStatus.MISSION_STATE_CHALLENGE);
            }
        });
        return memberMissionRepository.save(MemberMissionConverter.toMemberMission(member,mission));
    }
}
