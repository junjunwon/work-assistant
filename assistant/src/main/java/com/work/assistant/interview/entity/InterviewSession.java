package com.work.assistant.interview.entity;

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.interview.model.InterviewQuestionRequest;
import com.work.assistant.interview.model.InterviewSessionRequest;
import com.work.assistant.job.entity.Job;
import com.work.assistant.job.entity.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewSession extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public InterviewSession(Job job, Role role) {
        this.job = job;
        this.role = role;
    }
}
