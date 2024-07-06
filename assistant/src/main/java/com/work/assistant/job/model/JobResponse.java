package com.work.assistant.job.model;

import com.work.assistant.job.entity.Job;
import lombok.Getter;

@Getter
public class JobResponse {
    private Long id;
    private String title;

    public JobResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static JobResponse of(Job job) {
        return new JobResponse(job.getId(), job.getTitle());
    }
}
