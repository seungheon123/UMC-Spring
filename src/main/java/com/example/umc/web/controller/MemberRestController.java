package com.example.umc.web.controller;

import com.example.umc.apiPayload.ApiResponse;
import com.example.umc.converter.MemberConverter;
import com.example.umc.converter.ReviewConverter;
import com.example.umc.domain.mapping.Review;
import com.example.umc.service.MemberService.MemberCommandService;
import com.example.umc.validation.annotation.CheckPage;
import com.example.umc.validation.annotation.ExistMember;
import com.example.umc.web.dto.MemberResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @Operation(summary = "내가 작성한 리뷰 조회 API",description = "회원이 작성한 리뷰를 조회하는 API이며, 페이징 포함이다. query string으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId",description = "회원의 Id, Path Variable입니다"),
            @Parameter(name = "page",description = "페이지 번호, 0번이 1 페이지입니다"),
    })
    @GetMapping("/{memberId}")
    public ApiResponse<MemberResponseDto.MemberReviewPreviewListDto> getMemberReviewList(
            @ExistMember @PathVariable(name="memberId") Long memberId,
            @CheckPage @RequestParam(name="page") Integer page
    ){
        Page<Review> reviewList = memberCommandService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMemberReviewPreviewListDto(reviewList));
    }
}
