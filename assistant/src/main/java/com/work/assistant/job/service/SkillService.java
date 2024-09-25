package com.work.assistant.job.service;

import com.work.assistant.job.entity.Skill;
import com.work.assistant.job.model.SkillResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillDAOService skillDAOService;

    @Transactional(readOnly = true)
    public List<SkillResponse> getSkillsByInterviewId(Long interviewId) {
        List<Skill> skill = skillDAOService.getSkillsByInterviewId(interviewId);
        return skill.stream()
                .map(SkillResponse::of)
                .toList();
    }
}
