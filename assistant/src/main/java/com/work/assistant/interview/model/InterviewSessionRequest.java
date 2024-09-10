package com.work.assistant.interview.model;

import lombok.Getter;

@Getter
public record InterviewSessionRequest (Long id, Long jobId, Long roleId) {
}
