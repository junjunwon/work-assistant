package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewQuestion;
import com.work.assistant.interview.model.InterviewQuestionRequest;
import com.work.assistant.interview.model.InterviewQuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewQuestionService {

    private final InterviewQuestionDAOService interviewQuestionDAOService;

    @Transactional
    public void registerQuiz(InterviewQuestionRequest interviewQuestionRequest) {
        InterviewQuestion interviewQuestion = InterviewQuestion.create(interviewQuestionRequest);
        interviewQuestionDAOService.registerQuiz(interviewQuestion);
    }

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> getQuizList() {
        List<InterviewQuestion> interviewQuestionList = interviewQuestionDAOService.getQuizList();
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> getQuizzesByRoleId(Long roleId) {
        List<InterviewQuestion> interviewQuestionList = interviewQuestionDAOService.getQuizzesByRoleId(roleId);
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }
}
