package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewQuestion;
import com.work.assistant.interview.request.InterviewQuestionResponse;
import com.work.assistant.repository.jpa.QuestionRepository;
import com.work.assistant.repository.jpa.QuestionRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewQuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionRepositorySupport questionRepositorySupport;

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> findInterviewQuestions() {
        List<InterviewQuestion> interviewQuestionList = questionRepository.findAll();
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> getQuestionsBySkillId(Long skillId, long numberOfQuestions) {
        List<InterviewQuestion> interviewQuestionList = questionRepositorySupport.findRandomQuestions(skillId, numberOfQuestions);
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }
}
