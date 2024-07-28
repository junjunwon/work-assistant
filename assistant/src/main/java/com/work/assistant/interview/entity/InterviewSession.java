package com.work.assistant.interview.entity;

/**
 * InterviewSession 엔티티는 한 번의 면접 과정을 나타냅니다.
 * 면접 세션은 사용자가 특정 직군(Job)과 직무(Role)에 대해 면접을 시작하고 끝내는 모든 과정과 관련된 데이터를 포함합니다. 면접 세션 동안 사용자가 답변한 질문과 그 답변들을 추적하기 위해 사용됩니다.
 *
 * 각 면접 세션은 다음과 같은 정보들을 포함할 수 있습니다:
 * 면접이 시작되고 끝난 시간
 * 면접과 관련된 직군 및 직무
 * 면접 동안의 질문 및 답변
 */

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.interview.model.InterviewQuestionRequest;
import com.work.assistant.interview.model.InterviewSessionRequest;
import com.work.assistant.job.entity.Job;
import com.work.assistant.job.entity.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "interviewSession")
    private List<InterviewAnswer> interviewAnswers;

    public InterviewSession(Job job, Role role) {
        this.job = job;
        this.role = role;
    }
}
