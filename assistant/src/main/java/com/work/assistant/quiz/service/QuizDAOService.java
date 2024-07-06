package com.work.assistant.quiz.service;

import com.work.assistant.quiz.entity.Quiz;
import com.work.assistant.quiz.model.QuizRequest;
import com.work.assistant.repository.jpa.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizDAOService {
    private final QuizRepository quizRepository;

    public void registerQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public List<Quiz> getQuizList() {
        return quizRepository.findAll();
    }
}
