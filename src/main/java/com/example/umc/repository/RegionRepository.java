package com.example.umc.repository;

import com.example.umc.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,Long> {
    Optional<Region> findRegionByName(String name);
    boolean existsRegionByName(String name);
}


