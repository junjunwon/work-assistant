package com.work.assistant.job.model;

import com.work.assistant.job.entity.Job;
import com.work.assistant.job.entity.JobRole;
import lombok.Getter;

@Getter
public class JobRoleResponse {
    private Long id;
    private String title;

    public JobRoleResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static JobRoleResponse of(JobRole jobRole) {
        return new JobRoleResponse(jobRole.getId(), jobRole.getTitle());
    }
}
