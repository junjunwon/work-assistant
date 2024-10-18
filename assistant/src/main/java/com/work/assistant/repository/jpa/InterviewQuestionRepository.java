package com.work.assistant.repository.jpa;

import com.work.assistant.interview.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {
}
