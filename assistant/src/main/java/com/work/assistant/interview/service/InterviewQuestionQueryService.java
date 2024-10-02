package com.work.assistant.interview.service;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.work.assistant.interview.entity.InterviewQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.work.assistant.interview.entity.QInterviewQuestion.interviewQuestion;

@Component
@RequiredArgsConstructor
public class InterviewQuestionQueryService {

    private final JPAQueryFactory queryFactory;

    public List<InterviewQuestion> findRandomQuestions(Long skillId, long numberOfQuestions) {
        // 랜덤하게 질문 조회
        return queryFactory
                .selectFrom(interviewQuestion)
                .where(interviewQuestion.skill.id.eq(skillId))
                .orderBy(Expressions.numberTemplate(Double.class, "RANDOM()").asc())
                .limit(numberOfQuestions)
                .fetch();
    }
}
