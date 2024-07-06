package com.work.assistant.quiz.entity;

import com.work.assistant.quiz.model.QuizRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String answer;

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public static Quiz create(QuizRequest quizRequest) {
        return new Quiz(quizRequest.getQuestion(), quizRequest.getAnswer());
    }
}
