package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewQuestion;
import com.work.assistant.repository.jpa.InterviewQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InterviewQuestionDAOService {
    private final InterviewQuestionRepository interviewQuestionRepository;

    public void saveInterviewQuestion(InterviewQuestion interviewQuestion) {
        interviewQuestionRepository.save(interviewQuestion);
    }

    public List<InterviewQuestion> findInterviewQuestions() {
        return interviewQuestionRepository.findAll();
    }

    public List<InterviewQuestion> findInterviewQuestionsByRoleId(Long roleId) {
        return interviewQuestionRepository.findByRoleId(roleId);
    }
}
