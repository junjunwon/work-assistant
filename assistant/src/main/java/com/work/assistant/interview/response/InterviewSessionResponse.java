package com.work.assistant.interview.response;

import java.util.List;

public record InterviewSessionResponse (
    Long sessionId,
    String interviewTitle,
    String skillTitle,
    List<QuestionAsnwerResponse> questionAnswerResponses
) {
}
