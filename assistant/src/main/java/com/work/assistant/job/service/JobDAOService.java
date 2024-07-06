package com.work.assistant.job.service;

import com.work.assistant.job.entity.Job;
import com.work.assistant.quiz.entity.Quiz;
import com.work.assistant.repository.jpa.JobRepository;
import com.work.assistant.repository.jpa.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JobDAOService {
    private final JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
