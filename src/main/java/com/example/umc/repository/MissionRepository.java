package com.example.umc.repository;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
