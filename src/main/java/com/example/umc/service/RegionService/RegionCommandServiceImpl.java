package com.example.umc.service.RegionService;

import com.example.umc.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService {
    private final RegionRepository regionRepository;

    @Override
    public Boolean existRegionByName(String name) {
        return regionRepository.existsRegionByName(name);
    }
}
