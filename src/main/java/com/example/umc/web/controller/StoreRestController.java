package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.StoreConverter;
import com.example.umc.domain.Store;
import com.example.umc.service.ShopService.StoreCommandService;
import com.example.umc.web.dto.StoreRequestDto;
import com.example.umc.web.dto.StoreResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping()
    public ApiResponse<StoreResponseDto.RegisterResultDto> register(@RequestBody @Valid StoreRequestDto.StoreRegisterDto request){
        Store store = storeCommandService.registerStore(request);
        return ApiResponse.onSuccess(StoreConverter.toRegisterResultDto(store));
    }

}
