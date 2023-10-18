package com.okky.okkyclone.review.mapper;

import com.okky.okkyclone.review.dto.ReviewNewDto;
import com.okky.okkyclone.review.dto.ReviewResponseDto;
import com.okky.okkyclone.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review reviewNewDtoToReview(ReviewNewDto reviewNewDto){
        return new Review(reviewNewDto.getReview());
    }

    public ReviewResponseDto reviewToReviewResponseDto(Review review){
        return new ReviewResponseDto(review.getContent());
    }

}
