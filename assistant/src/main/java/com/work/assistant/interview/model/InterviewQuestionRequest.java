package com.work.assistant.interview.model;

import lombok.Getter;

@Getter
public record InterviewQuestionRequest (String question, String idealAnswer, Long categoryId){}
