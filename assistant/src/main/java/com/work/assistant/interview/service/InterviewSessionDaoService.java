package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewSession;
import com.work.assistant.repository.jpa.InterviewSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InterviewSessionDaoService {

    private final InterviewSessionRepository interviewSessionRepository;


    public void save(InterviewSession interviewSession) {
        interviewSessionRepository.save(interviewSession);
    }
}
