package com.work.assistant.job.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.job.entity.Interview;
import com.work.assistant.repository.jpa.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.work.assistant.common.exception.ExceptionStatus.WRONG_INTERVIEW;

@Component
@RequiredArgsConstructor
public class InterviewDAOService {
    private final InterviewRepository interviewRepository;

    public List<Interview> getInterviews() {
        return interviewRepository.findAll();
    }

    public Interview findByJobId(Long interviewId) {
        return interviewRepository.findById(interviewId).orElseThrow(() -> new CustomException(WRONG_INTERVIEW));
    }
}
