package com.work.assistant.repository.jpa;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.work.assistant.interview.entity.InterviewQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.work.assistant.interview.entity.QInterviewQuestion.interviewQuestion;

@Repository
@RequiredArgsConstructor
public class QuestionRepositorySupportImpl implements QuestionRepositorySupport {

    private final JPAQueryFactory queryFactory;

    @Override
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
