package com.example.umc.repository;

import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
