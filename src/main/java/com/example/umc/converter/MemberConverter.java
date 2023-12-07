package com.example.umc.converter;

import com.example.umc.domain.mapping.Review;
import com.example.umc.web.dto.MemberResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDto.MemberReviewPreviewListDto toMemberReviewPreviewListDto(Page<Review> reviewList) {
        List<MemberResponseDto.MemberReviewPreviewDto> previewDtoList = reviewList.stream()
                .map(review -> MemberResponseDto.MemberReviewPreviewDto.builder()
                        .name(review.getMember().getName())
                        .body(review.getContent())
                        .rating(review.getRating())
                        .createdAt(review.getCreatedAt().toLocalDate()).build())
                .collect(Collectors.toList());
        return MemberResponseDto.MemberReviewPreviewListDto.builder()
                .reviewList(previewDtoList)
                .build();
    }

    private static MemberResponseDto.MemberReviewPreviewDto toMemberReviewPreviewDto(Review review) {
        return MemberResponseDto.MemberReviewPreviewDto.builder()
                .name(review.getMember().getName())
                .body(review.getContent())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

}
