package com.work.assistant.repository.jpa;

import com.work.assistant.interview.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<InterviewQuestion, Long> {
    Optional<InterviewQuestion> findById(Long id);
}
