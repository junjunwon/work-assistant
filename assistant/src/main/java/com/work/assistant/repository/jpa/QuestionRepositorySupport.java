package com.work.assistant.repository.jpa;

import com.work.assistant.interview.entity.InterviewQuestion;

import java.util.List;

public interface QuestionRepositorySupport {
    List<InterviewQuestion> findRandomQuestions(Long skillId, long numberOfQuestions);
}
