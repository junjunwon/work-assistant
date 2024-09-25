package com.work.assistant.job.model;

import com.work.assistant.job.entity.Interview;
import lombok.Getter;

@Getter
public class InterviewResponse {
    private Long id;
    private String title;

    public InterviewResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static InterviewResponse of(Interview interview) {
        return new InterviewResponse(interview.getId(), interview.getTitle());
    }
}
