INSERT INTO interview (id, title, created_at, updated_at, created_by, updated_by) VALUES (1, '기술면접', NOW(), NOW(), 1, 1);

-- 역할 데이터 삽입
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (1, 'Java', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (2, 'Kotlin', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (3, 'Javascript', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (4, 'TypeScript', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (5, 'Python', 1, NOW(), NOW(), 1, 1);

-- 면접 질문 데이터 삽입
INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                                (1, '스프링 프레임워크란 무엇인가요?', '스프링은 자바 엔터프라이즈 애플리케이션 개발을 위한 가장 널리 사용되는 프레임워크입니다. 핵심 기능은 모든 자바 애플리케이션 개발에 사용될 수 있으며, Jakarta EE 플랫폼 위에 다양한 웹 애플리케이션을 구축할 수 있습니다.', 4, NOW(), NOW(), 1, 1),
                                (2, '스프링을 사용하는 이점은 무엇인가요?', '스프링은 Jakarta EE 개발을 쉽게 하기 위해 만들어졌습니다. 주요 이점으로는 경량성, 의존성 주입, 관점 지향 프로그래밍(AOP), IoC 컨테이너 관리, MVC 프레임워크, 트랜잭션 관리, 예외 처리 등이 있습니다.', 4, NOW(), NOW(), 1, 1),
                                (3, '스프링의 하위 프로젝트는 무엇이 있으며, 간단히 설명해주세요.', '핵심 모듈(Core), JDBC 통합, ORM 통합, 웹 통합 모듈, MVC 프레임워크, AOP 모듈이 있습니다.', 4, NOW(), NOW(), 1, 1),
                                (4, '의존성 주입이란 무엇인가요?', '의존성 주입은 IoC의 한 개념으로, 객체를 수동으로 생성하지 않고 IoC 컨테이너가 필요할 때 객체를 생성하도록 설명하는 것입니다.', 4, NOW(), NOW(), 1, 1),
                                (5, '스프링에서 빈을 주입하는 방법은 무엇인가요?', '빈 주입 방법으로는 셋터 주입, 생성자 주입, 필드 주입이 있습니다. 설정은 XML 파일이나 어노테이션을 통해 할 수 있습니다.', 4, NOW(), NOW(), 1, 1);
