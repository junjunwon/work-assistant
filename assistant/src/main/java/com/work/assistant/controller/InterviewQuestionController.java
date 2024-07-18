package com.work.assistant.controller;

import com.work.assistant.interview.model.InterviewQuestionRequest;
import com.work.assistant.interview.model.InterviewQuestionResponse;
import com.work.assistant.interview.service.InterviewQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/public/interview/question")
@RestController
@RequiredArgsConstructor
public class InterviewQuestionController {

    private final InterviewQuestionService interviewQuestionService;

    @PostMapping("")
    public ResponseEntity saveInterviewQuestion(@RequestBody InterviewQuestionRequest interviewQuestionRequest) {
        interviewQuestionService.registerQuiz(interviewQuestionRequest);
        return ResponseEntity.ok("질문 등록 성공");
    }

    @GetMapping("")
    public List<InterviewQuestionResponse> getInterviewQuestions() {
        return interviewQuestionService.getQuizList();
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<List<InterviewQuestionResponse>> getQuizzesByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(interviewQuestionService.getQuizzesByRoleId(roleId));
    }
}
