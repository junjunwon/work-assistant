package com.work.assistant.job.model;

import com.work.assistant.job.entity.Role;
import lombok.Getter;

@Getter
public class RoleResponse {
    private Long id;
    private String title;

    public RoleResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static RoleResponse of(Role role) {
        return new RoleResponse(role.getId(), role.getTitle());
    }
}
