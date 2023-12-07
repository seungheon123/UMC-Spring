package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.StoreConverter;
import com.example.umc.domain.Mission;
import com.example.umc.domain.Store;
import com.example.umc.service.StoreService.StoreCommandService;
import com.example.umc.validation.annotation.CheckPage;
import com.example.umc.validation.annotation.ExistStore;
import com.example.umc.web.dto.StoreRequestDto;
import com.example.umc.web.dto.StoreResponseDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping()
    public ApiResponse<StoreResponseDto.RegisterResultDto> register(@RequestBody @Valid StoreRequestDto.StoreRegisterDto request){
        Store store = storeCommandService.registerStore(request);
        return ApiResponse.onSuccess(StoreConverter.toRegisterResultDto(store));
    }

    @Operation(summary = "특정 가게의 미션 목록",description = "특정 가게의 미션 조희 API, 페이징 포함입니다. query string으로 페이지 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId",description = "가게 Id"),
            @Parameter(name = "page",description = "페이지 번호, 0이 1번 페이지입니다")
    })
    @GetMapping("{storeId}/missions")
    public ApiResponse<StoreResponseDto.StoreMissionListDto> getStoreMissionList(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page
    ){
        Page<Mission> missionList = storeCommandService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toStoreMissionListDto(missionList));
    }

}
