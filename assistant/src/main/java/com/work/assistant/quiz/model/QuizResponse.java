package com.work.assistant.quiz.model;

import com.work.assistant.quiz.entity.Quiz;
import lombok.Getter;

@Getter
public class QuizResponse {
    private Long id;
    private String question;
    private String answer;

    public QuizResponse(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public static QuizResponse of(Quiz quiz) {
        return new QuizResponse(quiz.getId(), quiz.getQuestion(), quiz.getAnswer());
    }
}
