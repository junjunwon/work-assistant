package com.work.assistant.job.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.job.entity.Skill;
import com.work.assistant.repository.jpa.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.work.assistant.common.exception.ExceptionStatus.WRONG_SKILL;

@Component
@RequiredArgsConstructor
public class SkillDAOService {
    private final SkillRepository skillRepository;

    public List<Skill> getSkillsByInterviewId(Long interviewId) {
        return skillRepository.findByInterviewId(interviewId);
    }

    public Skill findBySkillId(Long skillId) {
        return skillRepository.findById(skillId).orElseThrow(() -> new CustomException(WRONG_SKILL));
    }
}
