package com.example.umc.service.MemberService;

import com.example.umc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    @Override
    public boolean existMember(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}
