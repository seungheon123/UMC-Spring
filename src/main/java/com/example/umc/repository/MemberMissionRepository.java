package com.example.umc.repository;

import com.example.umc.domain.enums.MissionStatus;
import com.example.umc.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {

    boolean existsByIdAndMissionStatusNot(Long id, MissionStatus missionStatus);

    @Query("SELECT mm.missionStatus FROM MemberMission mm WHERE mm.id = :id")
    Optional<MissionStatus> findMissionStatusById(@Param("id") Long id);
}
