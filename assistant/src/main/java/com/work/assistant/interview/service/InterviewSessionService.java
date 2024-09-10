package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewAnswer;
import com.work.assistant.interview.entity.InterviewSession;
import com.work.assistant.interview.model.InterviewAnswerRequest;
import com.work.assistant.interview.model.InterviewSessionRequest;
import com.work.assistant.job.entity.Job;
import com.work.assistant.job.entity.Role;
import com.work.assistant.job.service.JobDAOService;
import com.work.assistant.job.service.RoleDAOService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewSessionService {

    private final InterviewSessionDaoService interviewSessionDaoService;
    private final JobDAOService jobDAOService;
    private final RoleDAOService roleDAOService;

    @Transactional
    public Long save(InterviewSessionRequest sessionRequest) {
        Job job = jobDAOService.findByJobId(sessionRequest.getJobId());
        Role role = roleDAOService.findByRoleId(sessionRequest.getRoleId());

        InterviewSession interviewSession = new InterviewSession(job, role);

        interviewSessionDaoService.save(interviewSession);

        return interviewSession.getId();
    }

    @Transactional
    public void saveSession(long sessionId, List<InterviewAnswerRequest> answerRequests) {
        InterviewSession interviewSession = interviewSessionDaoService.findById(sessionId);
        List<InterviewAnswer> interviewAnswers = new ArrayList<>();

        for (InterviewAnswerRequest answerRequest : answerRequests) {
            InterviewAnswer interviewAnswer =
                    InterviewAnswer.of(interviewSession, answerRequest.getQuestionId(), answerRequest.getAnswer());
            interviewAnswers.add(interviewAnswer);
        }
        interviewSession.updateInterviewAnswers(interviewAnswers);
        interviewSessionDaoService.save(interviewSession);

    }

    @Transactional
    public void endSession(int sessionId) {
    }
}
