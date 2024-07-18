package com.work.assistant.controller;

import com.work.assistant.job.model.RoleResponse;
import com.work.assistant.job.service.RoleService;
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
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/{jobId}")
    public ResponseEntity<List<RoleResponse>> getRolesByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(roleService.getRolesByJobId(jobId));
    }
}