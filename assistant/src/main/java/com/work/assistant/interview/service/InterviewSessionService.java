package com.work.assistant.interview.service;

import com.work.assistant.interview.entity.InterviewAnswer;
import com.work.assistant.interview.entity.InterviewSession;
import com.work.assistant.interview.request.InterviewAnswerRequest;
import com.work.assistant.interview.request.InterviewSessionRequest;
import com.work.assistant.interview.response.InterviewSessionResponse;
import com.work.assistant.interview.response.QuestionAsnwerResponse;
import com.work.assistant.job.entity.Interview;
import com.work.assistant.job.entity.Skill;
import com.work.assistant.job.service.InterviewDAOService;
import com.work.assistant.job.service.SkillDAOService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewSessionService {

    private final InterviewSessionDAOService interviewSessionDaoService;
    private final InterviewAnswerDaoService interviewAnswerDaoService;
    private final InterviewDAOService interviewDAOService;
    private final SkillDAOService skillDAOService;

    @Transactional
    public Long save(InterviewSessionRequest sessionRequest) {
        Interview interview = interviewDAOService.findByJobId(sessionRequest.interviewId());
        Skill skill = skillDAOService.findBySkillId(sessionRequest.skillId());

        InterviewSession interviewSession = new InterviewSession(interview, skill);

        interviewSessionDaoService.save(interviewSession);

        return interviewSession.getId();
    }

    @Transactional
    public void saveSession(long sessionId, List<InterviewAnswerRequest> answerRequests) {
        InterviewSession interviewSession = interviewSessionDaoService.findById(sessionId);
        List<InterviewAnswer> interviewAnswers = new ArrayList<>();

        for (InterviewAnswerRequest answerRequest : answerRequests) {
            InterviewAnswer interviewAnswer =
                    InterviewAnswer.of(interviewSession, answerRequest);
            interviewAnswers.add(interviewAnswer);
        }
        interviewSession.updateInterviewAnswers(interviewAnswers);

        interviewAnswerDaoService.saveAll(interviewAnswers);
    }

    @Transactional
    public InterviewSessionResponse getSessionResult(long sessionId) {
        InterviewSession interviewSession = interviewSessionDaoService.findById(sessionId);

        List<InterviewAnswer> answers = interviewSession.getInterviewAnswers();
        List<QuestionAsnwerResponse> responses = answers.stream()
                .map(QuestionAsnwerResponse::of)
                .toList();

        String interviewTitle = interviewSession.getInterviewTitle();
        String skillTitle = interviewSession.getSkillTitle();

        return new InterviewSessionResponse(
                interviewSession.getId(),
                interviewTitle, skillTitle, responses
        );
    }
}
