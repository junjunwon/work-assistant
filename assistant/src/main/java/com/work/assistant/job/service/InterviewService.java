package com.work.assistant.job.service;

import com.work.assistant.job.entity.Interview;
import com.work.assistant.job.model.InterviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewDAOService interviewDAOService;

    @Transactional(readOnly = true)
    public List<InterviewResponse> getInterviews() {
        List<Interview> interviewList = interviewDAOService.getInterviews();
        return interviewList.stream()
                .map(InterviewResponse::of)
                .toList();
    }
}
