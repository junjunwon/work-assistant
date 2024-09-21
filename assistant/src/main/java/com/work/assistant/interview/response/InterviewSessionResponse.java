package com.work.assistant.interview.response;

import java.util.List;

public record InterviewSessionResponse (
    Long sessionId,
    String jobTitle,
    String roleTitle,
    List<QuestionAsnwerResponse> questionAnswerResponses
) {
}
