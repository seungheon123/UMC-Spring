package com.example.umc.converter;

import com.example.umc.domain.Member;
import com.example.umc.domain.Store;
import com.example.umc.domain.mapping.Review;
import com.example.umc.web.dto.ReviewRequestDto;
import com.example.umc.web.dto.ReviewResponseDto;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDto.ReviewRegisterDto request, Member member, Store store){
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResponseDto.RegisterResultDto toRegisterResultDto(Review review){
        return ReviewResponseDto.RegisterResultDto.builder()
                .ReviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
