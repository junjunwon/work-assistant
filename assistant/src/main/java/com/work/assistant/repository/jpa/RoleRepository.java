package com.work.assistant.repository.jpa;

import com.work.assistant.job.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByJobId(Long jobId);
}
