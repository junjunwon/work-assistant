package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewQuestion;
import com.work.assistant.repository.jpa.InterviewQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InterviewQuestionDAOService {
    private final InterviewQuestionRepository interviewQuestionRepository;

    @Transactional(readOnly = true)
    public List<InterviewQuestion> findInterviewQuestions() {
        return interviewQuestionRepository.findAll();
    }
}
