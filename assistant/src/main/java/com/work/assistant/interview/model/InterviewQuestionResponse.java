package com.work.assistant.interview.model;

import com.work.assistant.interview.entity.InterviewQuestion;
import lombok.Getter;

@Getter
public class InterviewQuestionResponse {
    private Long id;
    private String question;

    public InterviewQuestionResponse(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public static InterviewQuestionResponse of(InterviewQuestion interviewQuestion) {
        return new InterviewQuestionResponse(interviewQuestion.getId(), interviewQuestion.getQuestion());
    }
}
