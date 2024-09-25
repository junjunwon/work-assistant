package com.work.assistant.job.entity;

import com.work.assistant.common.audit.Auditing;
import com.work.assistant.interview.entity.InterviewQuestion;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Skill extends Auditing  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @OneToMany(mappedBy = "skill")
    private List<InterviewQuestion> questions;
}
