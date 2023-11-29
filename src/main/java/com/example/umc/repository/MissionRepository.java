package com.example.umc.repository;

import com.example.umc.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
}
