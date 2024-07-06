package com.work.assistant.job.service;

import com.work.assistant.job.entity.Job;
import com.work.assistant.job.model.JobResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobDAOService jobDAOService;

    @Transactional(readOnly = true)
    public List<JobResponse> getAllJobs() {
        List<Job> jobList = jobDAOService.getAllJobs();
        return jobList.stream()
                .map(JobResponse::of)
                .toList();
    }
}
