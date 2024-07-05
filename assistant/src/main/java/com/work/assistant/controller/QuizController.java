package com.work.assistant.controller;

import com.work.assistant.quiz.model.QuizRequest;
import com.work.assistant.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/quiz")
@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/")
    public ResponseEntity registerQuiz(@RequestBody QuizRequest quizRequest) {
        return ResponseEntity.ok(quizService.registerQuiz(quizRequest));
    }
}
