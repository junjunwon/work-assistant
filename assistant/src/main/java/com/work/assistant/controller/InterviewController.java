package com.work.assistant.controller;

import com.work.assistant.job.model.InterviewResponse;
import com.work.assistant.job.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class InterviewController {
    private final InterviewService interviewService;

    @GetMapping("/interviews")
    public ResponseEntity<List<InterviewResponse>> getInterviews() {
        return ResponseEntity.ok(interviewService.getInterviews());
    }
}