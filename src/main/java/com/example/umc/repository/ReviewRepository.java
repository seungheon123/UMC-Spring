package com.example.umc.repository;

import com.example.umc.domain.mapping.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
