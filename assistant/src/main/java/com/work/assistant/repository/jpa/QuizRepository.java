package com.work.assistant.repository.jpa;

import com.work.assistant.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByRoleId(Long roleId);
}
