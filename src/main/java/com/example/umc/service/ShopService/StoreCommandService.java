package com.example.umc.service.ShopService;

import com.example.umc.domain.Store;
import com.example.umc.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Store registerStore(StoreRequestDto.StoreRegisterDto request);
}
