package com.work.assistant.controller;

import com.work.assistant.job.model.SkillResponse;
import com.work.assistant.job.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/skills/{interviewId}")
    public ResponseEntity<List<SkillResponse>> getSkillsByInterviewId(@PathVariable Long interviewId) {
        return ResponseEntity.ok(skillService.getSkillsByInterviewId(interviewId));
    }
}