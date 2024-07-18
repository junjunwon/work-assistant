package com.work.assistant.interview.entity;

/**
 * 각 면접 세션 동안의 질문과 답변을 저장하는 엔티티
 */

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.job.entity.Job;
import com.work.assistant.job.entity.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewAnswer extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private InterviewSession session;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private InterviewQuestion question;

    @Column(nullable = false)
    private String answer;
}
