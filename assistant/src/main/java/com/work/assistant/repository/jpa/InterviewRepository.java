package com.work.assistant.repository.jpa;

import com.work.assistant.job.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
