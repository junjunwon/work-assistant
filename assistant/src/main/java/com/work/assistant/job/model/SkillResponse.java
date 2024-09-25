package com.work.assistant.job.model;

import com.work.assistant.job.entity.Skill;
import lombok.Getter;

@Getter
public class SkillResponse {
    private Long id;
    private String title;

    public SkillResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static SkillResponse of(Skill skill) {
        return new SkillResponse(skill.getId(), skill.getTitle());
    }
}
