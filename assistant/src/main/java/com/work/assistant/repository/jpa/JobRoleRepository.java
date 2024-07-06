package com.work.assistant.repository.jpa;

import com.work.assistant.job.entity.JobRole;
import com.work.assistant.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
    List<JobRole> findByJobId(Long jobId);
}
