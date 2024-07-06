package com.work.assistant.quiz.service;

import com.work.assistant.quiz.entity.Quiz;
import com.work.assistant.quiz.model.QuizRequest;
import com.work.assistant.quiz.model.QuizResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizDAOService quizDAOService;

    @Transactional
    public void registerQuiz(QuizRequest quizRequest) {
        Quiz quiz = Quiz.create(quizRequest);
        quizDAOService.registerQuiz(quiz);
    }

    @Transactional(readOnly = true)
    public List<QuizResponse> getQuizList() {
        List<Quiz> quizList = quizDAOService.getQuizList();
        return quizList.stream()
                .map(QuizResponse::of)
                .toList();
    }
}
