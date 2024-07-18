package com.work.assistant.job.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.job.entity.Role;
import com.work.assistant.repository.jpa.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.work.assistant.common.exception.ExceptionStatus.WRONG_ROLE;

@Component
@RequiredArgsConstructor
public class RoleDAOService {
    private final RoleRepository roleRepository;

    public List<Role> getRolesByJobId(Long jobId) {
        return roleRepository.findByJobId(jobId);
    }

    public Role findByRoleId(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new CustomException(WRONG_ROLE));
    }
}
