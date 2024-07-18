package com.work.assistant.job.service;

import com.work.assistant.job.entity.Role;
import com.work.assistant.job.model.RoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleDAOService roleDAOService;

    @Transactional(readOnly = true)
    public List<RoleResponse> getRolesByJobId(Long jobId) {
        List<Role> role = roleDAOService.getRolesByJobId(jobId);
        return role.stream()
                .map(RoleResponse::of)
                .toList();
    }
}
