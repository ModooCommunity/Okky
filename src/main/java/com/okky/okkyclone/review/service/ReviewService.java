package com.okky.okkyclone.review.service;

import com.okky.okkyclone.review.entity.Review;

public interface ReviewService {

    void registerReview(Review review, Long questionId);

    Review editReview(Review review, Long reviewId);

    void deleteReview(Long reviewId);
}
