package com.okky.okkyclone.review.service;

import com.okky.okkyclone.Board.entity.Board;
import com.okky.okkyclone.Board.service.BoardService;
import com.okky.okkyclone.exception.BusinessLogicException;
import com.okky.okkyclone.exception.ExceptionCode;
import com.okky.okkyclone.review.entity.Review;
import com.okky.okkyclone.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BoardService boardService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, BoardService boardService) {
        this.reviewRepository = reviewRepository;
        this.boardService = boardService;
    }

    @Override
    public void registerReview(Review review, Long questionId) {
        Board findBoard = boardService.findVerifiedBoard(questionId);
        review.setBoard(findBoard);
        reviewRepository.save(review);
    }

    @Override
    public Review editReview(Review review, Long reviewId) {
        Review findReview = findVerifiedReview(reviewId);
        findReview.updateContent(review.getContent());
        return reviewRepository.save(findReview);
    }

    @Override
    public void deleteReview(Long reviewId) {
        Review fineReview = this.findVerifiedReview(reviewId);
        reviewRepository.delete(fineReview);
    }

    private Review findVerifiedReview(Long reviewId){
        return reviewRepository.findById(reviewId).orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.REVIEW_NOT_FOUND));
    }


}
