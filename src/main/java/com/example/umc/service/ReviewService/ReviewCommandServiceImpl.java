package com.example.umc.service.ReviewService;

import com.example.umc.apiPayload.code.status.ErrorStatus;
import com.example.umc.apiPayload.exception.handler.MemberHandler;
import com.example.umc.apiPayload.exception.handler.StoreHandler;
import com.example.umc.converter.ReviewConverter;
import com.example.umc.domain.Member;
import com.example.umc.domain.Store;
import com.example.umc.domain.mapping.Review;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.ReviewRepository;
import com.example.umc.repository.StoreRepository;
import com.example.umc.web.dto.ReviewRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review registerReview(ReviewRequestDto.ReviewRegisterDto request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(review);
    }

}
