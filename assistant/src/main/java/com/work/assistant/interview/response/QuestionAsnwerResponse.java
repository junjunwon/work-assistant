package com.work.assistant.interview.response;

import com.work.assistant.interview.entity.InterviewAnswer;

public record QuestionAsnwerResponse(String question, String answer) {
    public static QuestionAsnwerResponse of(InterviewAnswer interviewAnswer) {
        return new QuestionAsnwerResponse(interviewAnswer.getQuestion(), interviewAnswer.getAnswer());
    }
}
