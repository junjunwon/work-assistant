package com.work.assistant.interview.model;

import lombok.Getter;

@Getter
public class InterviewQuestionRequest {
    private String question;
    private String idealAnswer;
    private Long categoryId;
}
