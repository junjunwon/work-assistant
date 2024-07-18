package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewQuestion;
import com.work.assistant.repository.jpa.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InterviewQuestionDAOService {
    private final QuizRepository quizRepository;

    public void registerQuiz(InterviewQuestion interviewQuestion) {
        quizRepository.save(interviewQuestion);
    }

    public List<InterviewQuestion> getQuizList() {
        return quizRepository.findAll();
    }

    public List<InterviewQuestion> getQuizzesByRoleId(Long roleId) {
        return quizRepository.findByRoleId(roleId);
    }
}
