package com.example.umc.service.ReviewService;

import com.example.umc.domain.mapping.Review;
import com.example.umc.web.dto.ReviewRequestDto;

public interface ReviewCommandService {
    Review registerReview(ReviewRequestDto.ReviewRegisterDto request);
}
