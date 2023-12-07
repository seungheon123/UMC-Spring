package com.example.umc.service.StoreService;

import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.web.dto.StoreRequestDto;
import org.springframework.data.domain.Page;

public interface StoreCommandService {
    Store registerStore(StoreRequestDto.StoreRegisterDto request);
    Boolean existStore(Long storeId);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
