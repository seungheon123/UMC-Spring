package com.example.umc.repository;

import com.example.umc.domain.Member;
import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllByMemberAndMissionStatus(Member member,MissionStatus missionStatus, PageRequest pageRequest);

    @Query(value = "UPDATE MemberMission mm SET mm.missionStatus = 'COMPLETE' where mm.id=:memberMissionId")
    MemberMission updateMemberMissionStatusToComplete(@Param("memberMissionId") Long memberMissionId);
}
