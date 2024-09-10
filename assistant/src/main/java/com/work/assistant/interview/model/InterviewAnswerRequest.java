package com.work.assistant.interview.model;

import lombok.Getter;

@Getter
public record InterviewAnswerRequest (Long questionId, String answer) {}
