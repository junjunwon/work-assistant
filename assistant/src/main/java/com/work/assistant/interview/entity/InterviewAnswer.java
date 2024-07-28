package com.work.assistant.interview.entity;

/**
 * 각 면접 세션 동안의 질문과 답변을 저장하는 엔티티
 */

import com.work.assistant.common.audit.Auditing;
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
    @JoinColumn(name = "interview_session_id", nullable = false)
    private InterviewSession interviewSession;

    @ManyToOne
    @JoinColumn(name = "interview_question_id", nullable = false)
    private InterviewQuestion question;

    @Column(nullable = false)
    private String answer;
}
