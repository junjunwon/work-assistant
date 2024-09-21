package com.work.assistant.repository.jpa;

import com.work.assistant.interview.entity.InterviewAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewAnswerRepository extends JpaRepository<InterviewAnswer, Long> {
}
