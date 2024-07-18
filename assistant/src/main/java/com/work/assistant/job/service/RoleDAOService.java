package com.work.assistant.job.service;

import com.work.assistant.job.entity.Role;
import com.work.assistant.repository.jpa.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleDAOService {
    private final RoleRepository roleRepository;

    public List<Role> getJobRolesByJobId(Long jobId) {
        return roleRepository.findByJobId(jobId);
    }
}
