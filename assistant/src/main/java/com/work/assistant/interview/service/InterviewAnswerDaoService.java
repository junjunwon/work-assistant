package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewAnswer;
import com.work.assistant.repository.jpa.InterviewAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InterviewAnswerDaoService {

    private final InterviewAnswerRepository interviewAnswerRepository;

    public void saveAll(List<InterviewAnswer> interviewAnswers) {
        interviewAnswerRepository.saveAll(interviewAnswers);
    }
}
