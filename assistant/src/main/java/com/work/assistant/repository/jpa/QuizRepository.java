package com.work.assistant.repository.jpa;

import com.work.assistant.interview.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<InterviewQuestion, Long> {
    List<InterviewQuestion> findByRoleId(Long roleId);
}
