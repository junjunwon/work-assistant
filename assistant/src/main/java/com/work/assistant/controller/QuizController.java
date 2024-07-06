package com.work.assistant.controller;

import com.work.assistant.quiz.entity.Quiz;
import com.work.assistant.quiz.model.QuizRequest;
import com.work.assistant.quiz.model.QuizResponse;
import com.work.assistant.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/public/quiz")
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

    @GetMapping("/{roleId}")
    public ResponseEntity<List<QuizResponse>> getQuizzesByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(quizService.getQuizzesByRoleId(roleId));
    }
}
