package com.okky.okkyclone.Board.entity;

import com.okky.okkyclone.exception.BusinessLogicException;
import com.okky.okkyclone.exception.ExceptionCode;
import com.okky.okkyclone.helper.audit.BaseEntity;
import com.okky.okkyclone.review.entity.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "QUESTION")
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Enumerated(EnumType.STRING)
    private Topic topic;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public enum Topic {
        QUESTION("Question"),
        COMMUNITY("Community");

        @Getter
        private String stepDescription;

        Topic(String stepDescription){
            this.stepDescription = stepDescription;
        }
    }

    @Builder
    public Board(String topic, String title, String content){
        if (Objects.equals(topic, "Question")){
            this.topic = Topic.QUESTION;
        } else if (Objects.equals(topic, "Community")) {
            this.topic = Topic.COMMUNITY;
        } else {
            throw new BusinessLogicException(ExceptionCode.TOPIC_NOT_FOUND);
        }
        this.title = title;
        this.content = content;
    }

    public void editTopic(Topic topic){
        this.topic = topic;
    }

    public void editTitle(String title){
        this.title = title;
    }

    public void editContent(String content){
        this.content = content;
    }
}
