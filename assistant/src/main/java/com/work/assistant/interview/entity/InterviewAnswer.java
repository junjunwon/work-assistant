package com.work.assistant.interview.entity;

/**
 * 각 면접 세션 동안의 질문과 답변을 저장하는 엔티티
 */

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.interview.request.InterviewAnswerRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

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

    @Comment("InterviewQuestion 테이블 key")
    @Column(nullable = false)
    private long questionId;

    @Comment("모의 면접 당시 질문")
    @Column(nullable = false)
    private String question;

    @Comment("질문에 대한 지원자 답변")
    @Column(nullable = false)
    private String answer;

    public InterviewAnswer(InterviewSession interviewSession, long questionId,
                           String question, String answer) {
        this.interviewSession = interviewSession;
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public static InterviewAnswer of(InterviewSession interviewSession, InterviewAnswerRequest answerRequest) {
        return new InterviewAnswer(interviewSession, answerRequest.questionId(),
                answerRequest.question(), answerRequest.answer());
    }
}
