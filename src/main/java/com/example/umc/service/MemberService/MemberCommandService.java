package com.example.umc.service.MemberService;

import com.example.umc.domain.mapping.Review;
import org.springframework.data.domain.Page;

public interface MemberCommandService {
    boolean existMember(Long memberId);

    Page<Review> getReviewList(Long memberId, Integer page);
}
