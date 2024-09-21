package com.work.assistant.controller;

import com.work.assistant.interview.request.InterviewQuestionRequest;
import com.work.assistant.interview.request.InterviewQuestionResponse;
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
        interviewQuestionService.saveInterviewQuestion(interviewQuestionRequest);
        return ResponseEntity.ok("질문 등록 성공");
    }

    @GetMapping("")
    public List<InterviewQuestionResponse> getInterviewQuestions() {
        return interviewQuestionService.findInterviewQuestions();
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<List<InterviewQuestionResponse>> getQuizzesByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(interviewQuestionService.getQuizzesByRoleId(roleId));
    }
}
