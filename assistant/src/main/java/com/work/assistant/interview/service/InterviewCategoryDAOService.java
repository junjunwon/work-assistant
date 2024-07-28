package com.work.assistant.interview.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.common.exception.ExceptionStatus;
import com.work.assistant.interview.entity.InterviewCategory;
import com.work.assistant.repository.jpa.InterviewCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InterviewCategoryDAOService {
    private final InterviewCategoryRepository interviewCategoryRepository;

    public InterviewCategory findById(Long categoryId) {
        return interviewCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException(ExceptionStatus.WRONG_CATEGORY));
    }
}
