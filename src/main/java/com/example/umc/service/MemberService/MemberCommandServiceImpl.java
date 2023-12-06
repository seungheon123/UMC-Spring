package com.example.umc.service.MemberService;

import com.example.umc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    @Override
    public boolean existMember(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}
