package com.okky.okkyclone.review.repository;

import com.okky.okkyclone.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
