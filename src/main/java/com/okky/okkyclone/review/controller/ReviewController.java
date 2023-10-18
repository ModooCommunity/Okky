package com.okky.okkyclone.review.controller;

import com.okky.okkyclone.review.dto.ReviewNewDto;
import com.okky.okkyclone.review.dto.ReviewResponseDto;
import com.okky.okkyclone.review.entity.Review;
import com.okky.okkyclone.review.mapper.ReviewMapper;
import com.okky.okkyclone.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewMapper reviewMapper, ReviewService reviewService){
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
    }

    @PostMapping("/{question-id}")
    public ResponseEntity<Void> registerReview(@Valid @RequestBody ReviewNewDto reviewNewDto,
                                               @Positive @PathVariable("question-id") Long questionId){
        Review newReview = reviewMapper.reviewNewDtoToReview(reviewNewDto);
        reviewService.registerReview(newReview,questionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{review-id}")
    public ResponseEntity<ReviewResponseDto> editReview(@Valid @RequestBody ReviewNewDto reviewNewDto,
                                             @Positive @PathVariable("review-id") Long reviewId){
        Review editReview = reviewMapper.reviewNewDtoToReview(reviewNewDto);
        Review updateReview = reviewService.editReview(editReview,reviewId);
        return new ResponseEntity<>(reviewMapper.reviewToReviewResponseDto(updateReview),HttpStatus.OK);
    }

    @DeleteMapping("/{review-id}")
    public ResponseEntity<Void> deleteReview(@Positive @PathVariable("review-id") Long reviewId){
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
