package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewQuestion;
import com.work.assistant.interview.request.InterviewQuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewQuestionService {

    private final InterviewQuestionDAOService interviewQuestionDAOService;
    private final InterviewQuestionQueryService interviewQuestionQueryService;

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> findInterviewQuestions() {
        List<InterviewQuestion> interviewQuestionList = interviewQuestionDAOService.findInterviewQuestions();
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> getQuestionsBySkillId(Long skillId, long numberOfQuestions) {
        List<InterviewQuestion> interviewQuestionList = interviewQuestionQueryService.findRandomQuestions(skillId, numberOfQuestions);
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }
}
