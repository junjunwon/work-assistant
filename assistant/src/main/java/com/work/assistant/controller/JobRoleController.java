package com.work.assistant.controller;

import com.work.assistant.job.model.JobRoleResponse;
import com.work.assistant.job.service.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/roles")
@RequiredArgsConstructor
public class JobRoleController {
    private final JobRoleService jobRoleService;

    @GetMapping("/{jobId}")
    public ResponseEntity<List<JobRoleResponse>> getRolesByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(jobRoleService.getJobRolesByJobId(jobId));
    }
}