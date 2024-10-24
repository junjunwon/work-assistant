package com.work.assistant.interview.request;

import com.work.assistant.interview.entity.InterviewQuestion;

public record InterviewQuestionResponse (Long id, String question, String idealAnswer) {

    public InterviewQuestionResponse(Long id, String question, String idealAnswer) {
        this.id = id;
        this.question = question;
        this.idealAnswer = idealAnswer;
    }

    public static InterviewQuestionResponse of(InterviewQuestion interviewQuestion) {
        return new InterviewQuestionResponse(interviewQuestion.getId(), interviewQuestion.getQuestion(),
                interviewQuestion.getIdealAnswer());
    }
}
