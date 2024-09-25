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

    public List<InterviewQuestion> findInterviewQuestions() {
        return interviewQuestionRepository.findAll();
    }

    public List<InterviewQuestion> findInterviewQuestionsBySkillId(Long skillId) {
        return interviewQuestionRepository.findBySkillId(skillId);
    }
}
