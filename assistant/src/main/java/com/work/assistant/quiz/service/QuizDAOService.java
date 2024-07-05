package com.work.assistant.quiz.service;

import com.work.assistant.repository.jpa.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuizDAOService {
    private final QuizRepository quizRepository;
}
