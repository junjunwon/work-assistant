package com.work.assistant.job.service;

import com.work.assistant.job.entity.JobRole;
import com.work.assistant.quiz.entity.Quiz;
import com.work.assistant.repository.jpa.JobRoleRepository;
import com.work.assistant.repository.jpa.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JobRoleDAOService {
    private final JobRoleRepository jobRoleRepository;

    public List<JobRole> getJobRolesByJobId(Long jobId) {
        return jobRoleRepository.findByJobId(jobId);
    }
}
