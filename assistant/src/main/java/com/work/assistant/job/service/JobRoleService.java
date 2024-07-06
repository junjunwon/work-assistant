package com.work.assistant.job.service;

import com.work.assistant.job.entity.JobRole;
import com.work.assistant.job.model.JobRoleResponse;
import com.work.assistant.quiz.entity.Quiz;
import com.work.assistant.quiz.model.QuizRequest;
import com.work.assistant.quiz.model.QuizResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobRoleService {

    private final JobRoleDAOService jobRoleDAOService;

    @Transactional(readOnly = true)
    public List<JobRoleResponse> getJobRolesByJobId(Long jobId) {
        List<JobRole> jobRole = jobRoleDAOService.getJobRolesByJobId(jobId);
        return jobRole.stream()
                .map(JobRoleResponse::of)
                .toList();
    }
}
