package com.example.umc.service.MemberService;

import com.example.umc.domain.Member;
import com.example.umc.domain.mapping.Review;
import com.example.umc.repository.MemberRepository;
import com.example.umc.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public boolean existMember(Long memberId) {
        return memberRepository.existsById(memberId);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        return reviewRepository.findALlByMember(member, PageRequest.of(page, 10));
    }
}
