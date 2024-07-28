package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewCategory;
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
    private final InterviewCategoryDAOService interviewCategoryDAOService;

    @Transactional
    public void saveInterviewQuestion(InterviewQuestionRequest interviewQuestionRequest) {
        InterviewCategory interviewCategory = interviewCategoryDAOService.findById(interviewQuestionRequest.getCategoryId());
        InterviewQuestion interviewQuestion = InterviewQuestion.create(interviewQuestionRequest, interviewCategory);
        interviewQuestionDAOService.saveInterviewQuestion(interviewQuestion);
    }

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> findInterviewQuestions() {
        List<InterviewQuestion> interviewQuestionList = interviewQuestionDAOService.findInterviewQuestions();
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<InterviewQuestionResponse> getQuizzesByRoleId(Long roleId) {
        List<InterviewQuestion> interviewQuestionList = interviewQuestionDAOService.findInterviewQuestionsByRoleId(roleId);
        return interviewQuestionList.stream()
                .map(InterviewQuestionResponse::of)
                .toList();
    }
}
