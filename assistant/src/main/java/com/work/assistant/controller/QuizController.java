package com.work.assistant.controller;

import com.work.assistant.quiz.model.QuizRequest;
import com.work.assistant.quiz.model.QuizResponse;
import com.work.assistant.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/quiz")
@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("")
    public ResponseEntity registerQuiz(@RequestBody QuizRequest quizRequest) {
        quizService.registerQuiz(quizRequest);
        return ResponseEntity.ok("퀴즈 등록 성공");
    }

    @GetMapping("")
    public List<QuizResponse> getQuizList() {
        return quizService.getQuizList();
    }
}
