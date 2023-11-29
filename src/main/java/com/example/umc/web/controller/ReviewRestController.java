package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.ReviewConverter;
import com.example.umc.domain.mapping.Review;
import com.example.umc.service.ReviewService.ReviewCommandService;
import com.example.umc.web.dto.ReviewRequestDto;
import com.example.umc.web.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping()
    public ApiResponse<ReviewResponseDto.RegisterResultDto> register(@RequestBody @Valid ReviewRequestDto.ReviewRegisterDto request){

        Review review = reviewCommandService.registerReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toRegisterResultDto(review));
    }
}
