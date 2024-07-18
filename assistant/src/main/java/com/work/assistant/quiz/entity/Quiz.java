package com.work.assistant.quiz.entity;

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.job.entity.Role;
import com.work.assistant.quiz.model.QuizRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiz extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public static Quiz create(QuizRequest quizRequest) {
        return new Quiz(quizRequest.getQuestion(), quizRequest.getAnswer());
    }
}
