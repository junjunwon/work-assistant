package com.work.assistant.job.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.job.entity.Job;
import com.work.assistant.repository.jpa.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.work.assistant.common.exception.ExceptionStatus.WRONG_JOB;

@Component
@RequiredArgsConstructor
public class JobDAOService {
    private final JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job findByJobId(Long jobId) {
        return jobRepository.findById(jobId).orElseThrow(() -> new CustomException(WRONG_JOB));
    }
}
