package com.example.umc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

public class MemberResponseDto {



    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberReviewPreviewListDto{
        List<MemberReviewPreviewDto> reviewList;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberReviewPreviewDto{
        String name;
        String body;
        Integer rating;
        LocalDate createdAt;

    }
}
