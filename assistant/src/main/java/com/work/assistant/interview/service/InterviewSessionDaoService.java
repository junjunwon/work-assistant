package com.work.assistant.interview.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.interview.entity.InterviewSession;
import com.work.assistant.repository.jpa.InterviewSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.work.assistant.common.exception.ExceptionStatus.WRONG_SESSION;

@Component
@RequiredArgsConstructor
public class InterviewSessionDaoService {

    private final InterviewSessionRepository interviewSessionRepository;

    @Transactional
    public void save(InterviewSession interviewSession) {
        interviewSessionRepository.save(interviewSession);
    }

    @Transactional(readOnly = true)
    public InterviewSession findById(Long id) {
        return interviewSessionRepository.findById(id).orElseThrow(() -> new CustomException(WRONG_SESSION));
    }
}
