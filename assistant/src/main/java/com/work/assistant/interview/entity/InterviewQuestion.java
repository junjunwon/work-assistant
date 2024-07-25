package com.work.assistant.interview.entity;

/**
 * 면접 질문을 저장하는 엔티티로, 각 직무에 종속됨
 */

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.job.entity.Role;
import com.work.assistant.interview.model.InterviewQuestionRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InterviewQuestion extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @Column(columnDefinition = "TEXT")
    private String idealAnswer; // 이상적인 답변을 위한 필드 추가

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public InterviewQuestion(String question, String idealAnswer) {
        this.question = question;
        this.idealAnswer = idealAnswer;
    }

    public static InterviewQuestion create(InterviewQuestionRequest interviewQuestionRequest) {
        return new InterviewQuestion(interviewQuestionRequest.getQuestion(), interviewQuestionRequest.getIdealAnswer());
    }
}
