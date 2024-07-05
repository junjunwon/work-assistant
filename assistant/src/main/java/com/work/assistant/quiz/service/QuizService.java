package com.work.assistant.quiz.service;

import com.work.assistant.quiz.model.QuizRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizDAOService quizDAOService;

    public Object registerQuiz(QuizRequest quizRequest) {
        return null;
    }
}
