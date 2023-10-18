package com.okky.okkyclone.review.entity;

import com.okky.okkyclone.Board.entity.Board;
import com.okky.okkyclone.helper.audit.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "REVIEW")
@Entity
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @Builder
    public Review(String content){
        this.content = content;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void updateContent(String content){
        this.content = content;
    }
}
