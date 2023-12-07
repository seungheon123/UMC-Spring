package com.example.umc.repository;

import com.example.umc.domain.Member;
import com.example.umc.domain.mapping.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findALlByMember(Member member, PageRequest pageRequest);
}
