package com.work.assistant.interview.model;

import com.work.assistant.interview.entity.InterviewQuestion;

public record InterviewQuestionResponse (Long id, String question) {

    public InterviewQuestionResponse(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public static InterviewQuestionResponse of(InterviewQuestion interviewQuestion) {
        return new InterviewQuestionResponse(interviewQuestion.getId(), interviewQuestion.getQuestion());
    }
}
