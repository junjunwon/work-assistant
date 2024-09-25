package com.work.assistant.repository.jpa;

import com.work.assistant.job.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByInterviewId(Long jobId);
}
