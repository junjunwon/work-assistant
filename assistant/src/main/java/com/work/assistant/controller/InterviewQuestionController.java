package com.work.assistant.controller;

import com.work.assistant.interview.request.InterviewQuestionResponse;
import com.work.assistant.interview.service.InterviewQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/public/interview/question")
@RestController
@RequiredArgsConstructor
public class InterviewQuestionController {

    private final InterviewQuestionService interviewQuestionService;

    @GetMapping("")
    public List<InterviewQuestionResponse> getInterviewQuestions() {
        return interviewQuestionService.findInterviewQuestions();
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<List<InterviewQuestionResponse>> getQuizzesByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(interviewQuestionService.getQuestionsBySkillId(roleId));
    }
}
