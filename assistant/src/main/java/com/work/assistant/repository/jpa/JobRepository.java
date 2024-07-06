package com.work.assistant.repository.jpa;

import com.work.assistant.job.entity.Job;
import com.work.assistant.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}