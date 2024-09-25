INSERT INTO interview (id, title, created_at, updated_at, created_by, updated_by) VALUES (1, '기술면접', NOW(), NOW(), 1, 1);

-- 역할 데이터 삽입
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (1, 'Java', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (2, 'Kotlin', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (3, 'Javascript', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (4, 'TypeScript', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (5, 'Python', 1, NOW(), NOW(), 1, 1);
INSERT INTO skill (id, title, interview_id, created_at, updated_at, created_by, updated_by) VALUES (6, 'Spring Framework', 1, NOW(), NOW(), 1, 1);

-- 면접 질문 데이터 삽입
INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                              (1, 'Java의 주요 특징은 무엇인가요?', 'Java는 플랫폼 독립적이며, "Write Once, Run Anywhere"라는 철학을 따릅니다. 또한 객체 지향 언어로, 캡슐화, 상속, 다형성, 추상화의 OOP 개념을 충실히 지원하며, 멀티쓰레딩과 자동 메모리 관리(가비지 컬렉션)를 통해 높은 성능과 생산성을 제공합니다.', 1, NOW(), NOW(), 1, 1),
                              (2, 'JVM, JRE, JDK의 차이점은 무엇인가요?', 'JVM(Java Virtual Machine)은 Java 프로그램을 실행하는 환경으로 바이트코드를 기계어로 변환합니다. JRE(Java Runtime Environment)는 JVM을 포함한 실행에 필요한 라이브러리들로 구성되어 있으며, JDK(Java Development Kit)는 JRE에 개발에 필요한 컴파일러와 디버거 등의 도구가 추가된 패키지입니다.', 1, NOW(), NOW(), 1, 1),
                              (3, 'Java의 가비지 컬렉션은 어떻게 작동하나요?', 'Java의 가비지 컬렉션은 JVM이 메모리에서 더 이상 참조되지 않는 객체를 자동으로 해제하는 메커니즘입니다. 주로 Mark-and-Sweep 알고리즘을 사용하며, 성능 최적화를 위해 Young Generation과 Old Generation으로 나누어 처리하는 Generational Garbage Collection이 사용됩니다.', 1, NOW(), NOW(), 1, 1),
                              (4, '객체 지향 프로그래밍의 4대 원칙은 무엇인가요?', '객체 지향 프로그래밍의 4대 원칙은 캡슐화(데이터와 메소드를 하나의 객체로 묶음), 상속(기존 클래스의 속성을 물려받아 확장), 다형성(같은 인터페이스를 다양한 구현 방식으로 사용), 추상화(구현을 숨기고 중요한 부분만 노출)입니다.', 1, NOW(), NOW(), 1, 1),
                              (5, 'Overloading과 Overriding의 차이점은 무엇인가요?', 'Overloading은 동일한 메소드 이름을 갖지만 매개변수의 수나 타입이 다른 여러 메소드를 정의하는 것이고, Overriding은 부모 클래스에서 상속받은 메소드를 자식 클래스에서 재정의하는 것을 의미합니다.', 1, NOW(), NOW(), 1, 1),
                              (6, 'Exception과 Error의 차이점은 무엇인가요?', 'Exception은 프로그램 실행 중에 발생하는 문제로, 코드로 처리할 수 있는 반면, Error는 메모리 부족이나 시스템 문제처럼 치명적이며 애플리케이션에서 복구할 수 없는 문제입니다. Exception은 Checked와 Unchecked로 구분됩니다.', 1, NOW(), NOW(), 1, 1),
                              (7, 'Java에서 멀티쓰레딩을 구현하는 방법은 무엇인가요?', 'Java에서는 Thread 클래스를 상속하거나 Runnable 인터페이스를 구현하여 멀티쓰레딩을 구현할 수 있습니다. 또한, ExecutorService와 같은 고급 API를 사용하여 스레드 풀을 관리할 수 있습니다.', 1, NOW(), NOW(), 1, 1),
                              (8, 'Synchronized 키워드는 어떻게 사용되나요?', 'synchronized 키워드는 멀티쓰레딩 환경에서 동기화를 보장하기 위해 사용됩니다. 이는 특정 코드 블록이나 메소드가 한 번에 하나의 쓰레드만 접근할 수 있도록 제한하여 데이터 일관성을 유지합니다.', 1, NOW(), NOW(), 1, 1),
                              (9, 'Java에서 Immutable 객체는 무엇이며, 어떻게 만들 수 있나요?', 'Immutable 객체는 생성된 후 상태를 변경할 수 없는 객체입니다. 클래스를 불변하게 만들려면 모든 필드를 final로 선언하고, 수정자 메소드를 제공하지 않으며, 객체 내부의 가변 필드를 복사하여 반환해야 합니다.', 1, NOW(), NOW(), 1, 1),
                              (10, 'HashMap과 Hashtable의 차이점은 무엇인가요?', 'HashMap은 동기화되지 않으며, null 키와 값을 허용하는 반면, Hashtable은 동기화되어 있어 쓰레드 안전하지만 성능이 다소 떨어지고 null 키와 값을 허용하지 않습니다.', 1, NOW(), NOW(), 1, 1),
                              (11, 'ConcurrentHashMap은 어떻게 동작하나요?', 'ConcurrentHashMap은 동기화된 해시맵으로, 내부적으로 여러 개의 세그먼트로 나누어 동시 접근을 허용하면서도 성능을 최적화합니다. 각 세그먼트는 개별적으로 락을 걸어 동시성 문제를 해결합니다.', 1, NOW(), NOW(), 1, 1),
                              (12, 'Java에서 제네릭(Generics)의 역할은 무엇인가요?', '제네릭은 컴파일 타임에 타입 안전성을 제공하여, 컬렉션 또는 메소드에서 특정 타입을 강제하는 기능입니다. 제네릭을 사용하면 불필요한 캐스팅을 줄일 수 있습니다.', 1, NOW(), NOW(), 1, 1),
                              (13, 'Lambda 표현식은 무엇인가요?', 'Lambda 표현식은 Java 8에서 도입된 기능으로, 익명 클래스를 더 간결하게 표현하는 방법입니다. 함수형 인터페이스의 구현체를 간결하게 정의할 수 있어 코드 가독성이 높아집니다.', 1, NOW(), NOW(), 1, 1),
                              (14, 'Functional Interface란 무엇인가요?', 'Functional Interface는 단 하나의 추상 메소드를 가지는 인터페이스로, @FunctionalInterface 어노테이션을 통해 명시할 수 있습니다. 주로 람다 표현식에서 사용됩니다.', 1, NOW(), NOW(), 1, 1),
                              (15, 'Stream API의 역할은 무엇인가요?', 'Stream API는 Java 8에서 도입된 기능으로, 컬렉션이나 배열에 대한 복잡한 데이터 처리 작업을 함수형 프로그래밍 방식으로 수행할 수 있습니다. 스트림은 데이터를 필터링, 매핑, 축소 등의 연산을 효율적으로 처리합니다.', 1, NOW(), NOW(), 1, 1),
                              (16, 'JDBC란 무엇이며, 어떻게 사용하나요?', 'JDBC(Java Database Connectivity)는 Java에서 데이터베이스와 통신하기 위한 API입니다. 이를 통해 SQL 쿼리를 실행하고 결과를 처리할 수 있습니다.', 1, NOW(), NOW(), 1, 1),
                              (17, 'JPA와 Hibernate의 차이점은 무엇인가요?', 'JPA(Java Persistence API)는 자바 애플리케이션에서 관계형 데이터베이스를 매핑하기 위한 인터페이스입니다. Hibernate는 JPA의 구현체로, 추가적인 기능과 성능 최적화 옵션을 제공합니다.', 1, NOW(), NOW(), 1, 1),
                              (18, 'Optional 클래스는 왜 사용되나요?', 'Optional 클래스는 null 값을 처리하기 위해 도입된 Java 8의 기능으로, 명시적으로 값이 있을 수도 없을 수도 있음을 표현하며, NPE(NullPointerException)를 방지하는 데 도움이 됩니다.', 1, NOW(), NOW(), 1, 1),
                              (19, 'ClassLoader는 무엇이고, 어떻게 동작하나요?', 'ClassLoader는 JVM이 클래스를 동적으로 로드하는 데 사용됩니다. 기본적으로 세 가지 ClassLoader가 있으며, 각각 부트스트랩, 확장, 시스템 ClassLoader로 나뉘어 계층적으로 클래스를 로드합니다.', 1, NOW(), NOW(), 1, 1),
                              (20, 'Java의 메모리 구조는 어떻게 되어 있나요?', 'Java의 메모리 구조는 Heap, Stack, Method Area, Native Method Stack으로 나뉩니다. Heap은 객체가 저장되는 공간이고, Stack은 각 쓰레드의 호출 스택이 저장됩니다. Method Area는 클래스 정보가 저장되고, Native Method Stack은 네이티브 코드 실행 시 사용됩니다.', 1, NOW(), NOW(), 1, 1);


INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                              (21, 'Python의 주요 특징은 무엇인가요?', 'Python은 간결하고 읽기 쉬운 문법을 가지고 있으며, 동적 타이핑과 인터프리터 언어로 다양한 플랫폼에서 실행 가능합니다. 또한 풍부한 라이브러리와 커뮤니티 지원을 제공합니다.', 5, NOW(), NOW(), 1, 1),
                              (22, 'Python의 GIL(Global Interpreter Lock)은 무엇인가요?', 'GIL은 Python에서 동시에 하나의 스레드만 실행할 수 있도록 하는 메커니즘입니다. 이는 멀티쓰레딩 성능에 제한을 두지만, 메모리 관리 및 C 확장 라이브러리와의 호환성을 보장합니다.', 5, NOW(), NOW(), 1, 1),
                              (23, 'Python에서 mutable과 immutable 데이터 타입의 차이점은 무엇인가요?', 'mutable 데이터 타입은 변경 가능하고, immutable 데이터 타입은 변경이 불가능합니다. 예를 들어, 리스트는 mutable이고, 튜플과 문자열은 immutable입니다.', 5, NOW(), NOW(), 1, 1),
                              (24, '리스트와 튜플의 차이점은 무엇인가요?', '리스트는 변경 가능하며, 튜플은 변경 불가능합니다. 리스트는 데이터의 추가, 삭제가 가능하지만, 튜플은 생성된 이후 데이터를 수정할 수 없습니다.', 5, NOW(), NOW(), 1, 1),
                              (25, 'Python에서 *args와 **kwargs는 무엇을 의미하나요?', '*args는 임의 개수의 위치 인수를, **kwargs는 임의 개수의 키워드 인수를 받을 수 있습니다.', 5, NOW(), NOW(), 1, 1),
                              (26, 'Python의 메모리 관리는 어떻게 이루어지나요?', 'Python은 자동으로 메모리를 관리하며, 주로 참조 카운팅(reference counting)과 가비지 컬렉션(garbage collection)을 통해 메모리 누수를 방지합니다.', 5, NOW(), NOW(), 1, 1),
                              (27, '파이썬의 예외 처리 구조는 어떻게 동작하나요?', 'try-except-else-finally 블록을 사용하여 예외를 처리하며, 필요한 경우 사용자 정의 예외를 만들 수 있습니다.', 5, NOW(), NOW(), 1, 1),
                              (28, 'Python에서 데코레이터(Decorator)는 무엇인가요?', '데코레이터는 함수를 감싸는 또 다른 함수로, 함수를 수정하지 않고도 추가적인 기능을 적용할 수 있습니다.', 5, NOW(), NOW(), 1, 1),
                              (29, '파이썬의 Lambda 함수는 무엇이며 어떻게 사용하나요?', 'Lambda 함수는 익명 함수로, 짧은 함수 정의에 유용합니다. 간단한 연산이나 필터링에 자주 사용됩니다.', 5, NOW(), NOW(), 1, 1),
                              (30, '파이썬에서 제너레이터(Generator)는 어떻게 작동하나요?', '제너레이터는 이터레이터를 생성하는 특별한 함수로, yield 키워드를 사용해 값을 반환하고, 메모리를 효율적으로 사용합니다.', 5, NOW(), NOW(), 1, 1),
                              (31, 'Python의 리스트 내포(List Comprehension)는 무엇인가요?', '리스트 내포는 간결하게 리스트를 생성할 수 있는 구문으로, 기존 리스트에서 조건문과 반복문을 이용해 새로운 리스트를 만들 수 있습니다.', 5, NOW(), NOW(), 1, 1),
                              (32, 'Python에서 모듈과 패키지의 차이점은 무엇인가요?', '모듈은 하나의 파이썬 파일이고, 패키지는 여러 모듈을 포함하는 디렉토리입니다. 패키지는 모듈을 계층적으로 관리할 수 있게 해줍니다.', 5, NOW(), NOW(), 1, 1),
                              (33, '파이썬에서 가비지 컬렉션(Garbage Collection)은 어떻게 이루어지나요?', 'Python의 가비지 컬렉션은 주로 참조 카운팅과 순환 참조 감지를 통해 불필요한 객체를 메모리에서 해제합니다.', 5, NOW(), NOW(), 1, 1),
                              (34, '파이썬에서 클래스와 인스턴스 메소드의 차이점은 무엇인가요?', '클래스 메소드는 클래스 레벨에서 호출되고 인스턴스가 없어도 호출 가능합니다. 반면 인스턴스 메소드는 특정 인스턴스에 바인딩되어 호출됩니다.', 5, NOW(), NOW(), 1, 1),
                              (35, 'Python에서 다중 상속은 어떻게 동작하나요?', 'Python에서는 다중 상속을 지원하지만, 복잡한 상속 관계를 피하고 MRO(Method Resolution Order)를 이해하는 것이 중요합니다.', 5, NOW(), NOW(), 1, 1),
                              (36, 'Python에서 with 문은 무엇을 의미하나요?', 'with 문은 리소스를 자동으로 정리할 수 있는 구조로, 파일 처리나 데이터베이스 연결과 같은 코드에서 자주 사용됩니다.', 5, NOW(), NOW(), 1, 1),
                              (37, '파이썬에서 shallow copy와 deep copy의 차이점은 무엇인가요?', 'shallow copy는 객체의 최상위 레벨만 복사하고, deep copy는 모든 레벨의 객체를 재귀적으로 복사합니다.', 5, NOW(), NOW(), 1, 1),
                              (38, 'Python에서 정규 표현식(Regex)을 어떻게 사용하나요?', '정규 표현식은 re 모듈을 사용하여 패턴 매칭, 문자열 검색, 치환 등의 작업을 수행할 수 있습니다.', 5, NOW(), NOW(), 1, 1),
                              (39, 'Python의 클로저(Closure)는 무엇인가요?', '클로저는 함수가 정의될 때의 변수를 기억하는 함수를 의미하며, 함수 내부에서 함수가 정의될 때 발생합니다.', 5, NOW(), NOW(), 1, 1),
                              (40, '파이썬에서 데이터베이스와 연결하는 방법은 무엇인가요?', 'Python의 sqlite3 라이브러리를 사용해 SQLite와 같은 경량 데이터베이스에 연결할 수 있습니다. 더 큰 데이터베이스는 SQLAlchemy나 Django ORM을 사용할 수 있습니다.', 5, NOW(), NOW(), 1, 1);


INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                              (41, 'JavaScript의 주요 특징은 무엇인가요?', 'JavaScript는 동적 타입을 지원하며, 브라우저 내에서 클라이언트 측 스크립트를 실행하는 데 주로 사용됩니다. 인터프리터 언어이자 이벤트 기반으로 비동기 처리를 효율적으로 수행합니다.', 3, NOW(), NOW(), 1, 1),
                              (42, 'var, let, const의 차이점은 무엇인가요?', 'var는 함수 스코프를 가지며, let과 const는 블록 스코프를 가집니다. const는 상수로 한 번 선언된 이후 값을 변경할 수 없습니다.', 3, NOW(), NOW(), 1, 1),
                              (43, 'JavaScript에서 호이스팅(hoisting)이란 무엇인가요?', '호이스팅은 변수와 함수 선언이 해당 스코프의 최상단으로 끌어올려지는 동작을 의미합니다. 이는 변수 선언이 실제 코드보다 먼저 실행되는 것처럼 보이게 만듭니다.', 3, NOW(), NOW(), 1, 1),
                              (44, '클로저(Closure)는 무엇이며, 어떻게 작동하나요?', '클로저는 함수가 자신이 선언될 때의 렉시컬 환경을 기억하는 특성입니다. 이는 함수 외부의 변수에 접근할 수 있도록 해줍니다.', 3, NOW(), NOW(), 1, 1),
                              (45, 'this 키워드는 JavaScript에서 어떻게 동작하나요?', 'this는 함수 호출 방식에 따라 달라집니다. 일반적으로 객체의 메소드를 호출할 때 그 객체를 참조하지만, 함수의 호출 문맥에 따라 달라질 수 있습니다.', 3, NOW(), NOW(), 1, 1),
                              (46, 'Arrow function과 일반 함수 표현식의 차이점은 무엇인가요?', 'Arrow function은 일반 함수와 달리 this 바인딩을 하지 않으며, 렉시컬 스코프를 따릅니다. 따라서 콜백 함수로 사용할 때 편리합니다.', 3, NOW(), NOW(), 1, 1),
                              (47, 'JavaScript에서 프로미스(Promise)란 무엇인가요?', '프로미스는 비동기 작업의 완료 또는 실패를 나타내는 객체입니다. then과 catch 메소드를 사용하여 후속 처리 작업을 정의할 수 있습니다.', 3, NOW(), NOW(), 1, 1),
                              (48, 'async/await는 어떻게 동작하나요?', 'async/await는 프로미스를 더 간결하게 사용할 수 있는 구문으로, 비동기 코드를 동기 코드처럼 작성할 수 있게 도와줍니다.', 3, NOW(), NOW(), 1, 1),
                              (49, 'JavaScript에서 이벤트 버블링(Event Bubbling)과 캡처링(Event Capturing)이란 무엇인가요?', '이벤트 버블링은 하위 요소에서 발생한 이벤트가 상위 요소로 전파되는 현상이며, 캡처링은 그 반대입니다.', 3, NOW(), NOW(), 1, 1),
                              (50, 'JavaScript에서 스코프(Scope)와 렉시컬 스코프(Lexical Scope)는 무엇인가요?', '스코프는 변수나 함수가 접근 가능한 범위를 의미하며, 렉시컬 스코프는 함수가 선언될 당시의 스코프를 기억하는 방식입니다.', 3, NOW(), NOW(), 1, 1),
                              (51, 'JavaScript에서 타입 강제 변환(Type Coercion)이란 무엇인가요?', '타입 강제 변환은 JavaScript가 자동으로 데이터 타입을 변환하는 과정입니다. 예를 들어, 문자열과 숫자를 더하면 JavaScript는 숫자를 문자열로 변환합니다.', 3, NOW(), NOW(), 1, 1),
                              (52, '==와 ===의 차이점은 무엇인가요?', '==는 값만 비교하며, ===는 값과 데이터 타입 모두를 비교합니다. ===는 타입을 엄격히 검사하므로 권장됩니다.', 3, NOW(), NOW(), 1, 1),
                              (53, 'JavaScript에서 객체(Object)와 배열(Array)의 차이점은 무엇인가요?', '객체는 키-값 쌍을 가지는 데이터 구조이고, 배열은 순서가 있는 리스트입니다. 배열은 인덱스를 통해 요소에 접근할 수 있습니다.', 3, NOW(), NOW(), 1, 1),
                              (54, 'JavaScript에서 비동기(Asynchronous) 코드 처리는 어떻게 이루어지나요?', '비동기 코드는 콜백, 프로미스, async/await를 사용하여 처리되며, 이벤트 루프가 이를 관리하여 성능을 최적화합니다.', 3, NOW(), NOW(), 1, 1),
                              (55, 'JavaScript에서 모듈화(Module)란 무엇인가요?', '모듈화는 코드를 여러 파일로 분리하여 관리하는 방식으로, JavaScript에서는 import와 export를 통해 모듈 간의 데이터를 공유할 수 있습니다.', 3, NOW(), NOW(), 1, 1),
                              (56, 'JavaScript의 프로토타입(prototype) 상속이란 무엇인가요?', '프로토타입 상속은 객체가 다른 객체로부터 속성과 메소드를 상속받는 방식입니다. 모든 객체는 프로토타입 객체를 가집니다.', 3, NOW(), NOW(), 1, 1),
                              (57, '이벤트 루프(Event Loop)는 어떻게 작동하나요?', '이벤트 루프는 콜 스택과 태스크 큐를 관리하여 비동기 작업이 완료되면 실행하도록 보장합니다.', 3, NOW(), NOW(), 1, 1),
                              (58, 'JavaScript에서 "use strict"는 무엇이며, 왜 사용하나요?', '"use strict"는 엄격 모드로, 오류를 줄이고 더 안전한 코드를 작성하도록 도와줍니다. 예를 들어, 선언되지 않은 변수를 사용하지 못하게 합니다.', 3, NOW(), NOW(), 1, 1),
                              (59, 'JavaScript에서 call, apply, bind의 차이점은 무엇인가요?', 'call과 apply는 함수의 this를 명시적으로 바인딩하는 메소드이며, 차이점은 인수를 전달하는 방식입니다. bind는 새로운 함수를 반환하여 this를 고정합니다.', 3, NOW(), NOW(), 1, 1),
                              (60, 'JavaScript에서 메모리 관리는 어떻게 이루어지나요?', 'JavaScript는 가비지 컬렉션을 통해 더 이상 참조되지 않는 객체를 자동으로 메모리에서 해제합니다.', 3, NOW(), NOW(), 1, 1);

INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                              (61, 'TypeScript의 주요 특징은 무엇인가요?', 'TypeScript는 JavaScript의 슈퍼셋으로 정적 타입을 지원하며, 컴파일 타임에 오류를 잡을 수 있어 안정성이 높습니다. 클래스, 인터페이스, 제네릭 등을 지원하여 더 구조적인 코드 작성이 가능합니다.', 4, NOW(), NOW(), 1, 1),
                              (62, 'TypeScript와 JavaScript의 차이점은 무엇인가요?', 'JavaScript는 동적 타입 언어이며, 런타임에 오류가 발생할 수 있습니다. 반면 TypeScript는 정적 타입 언어로, 코드 작성 시점에서 타입을 체크하여 오류를 사전에 방지합니다.', 4, NOW(), NOW(), 1, 1),
                              (63, 'TypeScript에서 인터페이스(Interface)란 무엇인가요?', '인터페이스는 객체의 구조를 정의하는 데 사용되며, 클래스나 객체의 모양을 설명하는 계약 역할을 합니다. 인터페이스는 여러 타입 간에 공통된 구조를 강제할 수 있습니다.', 4, NOW(), NOW(), 1, 1),
                              (64, 'TypeScript에서 타입(Type)을 정의하는 방법은 무엇인가요?', '타입을 정의하려면 type 키워드를 사용합니다. 이는 객체, 함수, 배열 등 다양한 형태의 타입을 정의하는 데 사용되며, 코드의 가독성과 재사용성을 높입니다.', 4, NOW(), NOW(), 1, 1),
                              (65, 'TypeScript의 제네릭(Generics)은 무엇인가요?', '제네릭은 함수, 클래스, 인터페이스에서 타입을 변수로 다룰 수 있게 해주며, 코드의 재사용성을 높이는 동시에 타입 안정성을 유지할 수 있게 해줍니다.', 4, NOW(), NOW(), 1, 1),
                              (66, 'any 타입의 사용은 언제 권장되나요?', 'any 타입은 모든 타입을 허용하는 특수 타입으로, 주로 외부 라이브러리나 기존 JavaScript 코드와의 통합 시 사용되지만, 남용할 경우 타입 안정성이 떨어지므로 최소한으로 사용하는 것이 좋습니다.', 4, NOW(), NOW(), 1, 1),
                              (67, 'TypeScript의 타입 가드(Type Guard)란 무엇인가요?', '타입 가드는 런타임 시 변수의 타입을 좁히는 메커니즘으로, 조건문 등을 통해 특정 타입인지 확인하여 안전한 타입 체크를 수행할 수 있습니다.', 4, NOW(), NOW(), 1, 1),
                              (68, 'null과 undefined의 차이는 무엇인가요?', 'null은 의도적으로 값이 없음을 나타내고, undefined는 값이 할당되지 않았음을 나타냅니다. TypeScript에서는 null과 undefined 모두 기본 타입에 포함되며, 엄격한 타입 검사를 통해 처리됩니다.', 4, NOW(), NOW(), 1, 1),
                              (69, 'TypeScript에서 readonly와 const의 차이는 무엇인가요?', 'readonly는 객체의 속성이 수정되지 않도록 하는 데 사용되며, const는 변수 재할당을 막습니다. readonly는 객체 내부의 필드에 적용되지만, const는 변수 자체에 적용됩니다.', 4, NOW(), NOW(), 1, 1),
                              (70, 'TypeScript에서 유니언 타입(Union Types)이란 무엇인가요?', '유니언 타입은 하나 이상의 타입을 허용하는 타입으로, 변수가 여러 타입 중 하나를 가질 수 있도록 정의할 수 있습니다. 예: string | number.', 4, NOW(), NOW(), 1, 1),
                              (71, 'TypeScript에서 인터섹션 타입(Intersection Types)이란 무엇인가요?', '인터섹션 타입은 여러 타입을 하나로 결합하여, 모든 속성을 포함하는 새로운 타입을 만드는 데 사용됩니다. 예: A & B.', 4, NOW(), NOW(), 1, 1),
                              (72, 'TypeScript의 타입 단언(Type Assertion)이란 무엇인가요?', '타입 단언은 개발자가 해당 값이 특정 타입이라고 컴파일러에게 알리는 방법입니다. 이는 컴파일러가 자동으로 타입을 추론할 수 없을 때 사용됩니다.', 4, NOW(), NOW(), 1, 1),
                              (73, 'TypeScript에서 디코레이터(Decorator)는 무엇이며, 어떻게 사용되나요?', '디코레이터는 클래스나 메소드에 기능을 추가할 수 있는 특수한 선언으로, 주로 메타데이터를 추가하거나 함수의 동작을 수정하는 데 사용됩니다.', 4, NOW(), NOW(), 1, 1),
                              (74, 'TypeScript에서 enum은 무엇이며, 언제 사용하나요?', 'enum은 열거형 타입으로, 값들의 집합에 이름을 붙여 관리하는 방식입니다. 주로 상수 값을 정의할 때 사용되며, 가독성과 유지보수성을 높입니다.', 4, NOW(), NOW(), 1, 1),
                              (75, 'TypeScript에서 모듈 시스템은 어떻게 작동하나요?', 'TypeScript의 모듈 시스템은 import와 export 키워드를 사용하여 코드를 분리하고 재사용할 수 있게 해줍니다. 모듈을 통해 전역 네임스페이스 오염을 방지할 수 있습니다.', 4, NOW(), NOW(), 1, 1),
                              (76, 'TypeScript에서 any와 unknown의 차이점은 무엇인가요?', 'any는 모든 타입을 허용하지만, unknown은 엄격한 타입 체크를 요구합니다. unknown은 사용하기 전에 명시적으로 타입을 확인해야 합니다.', 4, NOW(), NOW(), 1, 1),
                              (77, 'TypeScript에서 async/await는 어떻게 동작하나요?', 'async/await는 비동기 코드를 동기식 코드처럼 작성할 수 있게 해주는 구문입니다. async 키워드를 사용하여 함수를 비동기 함수로 선언하고, await 키워드를 사용하여 프로미스의 결과를 기다립니다.', 4, NOW(), NOW(), 1, 1),
                              (78, 'TypeScript에서 함수 오버로딩(Function Overloading)이란 무엇인가요?', '함수 오버로딩은 하나의 함수가 여러 개의 타입 시그니처를 가질 수 있도록 정의하는 것입니다. 이를 통해 동일한 함수가 다양한 인수를 처리할 수 있게 됩니다.', 4, NOW(), NOW(), 1, 1),
                              (79, 'TypeScript에서 keyof와 typeof는 어떻게 사용되나요?', 'keyof는 객체 타입의 키를 타입으로 추출하는 데 사용되며, typeof는 변수의 타입을 추론하는 데 사용됩니다. 이 둘은 동적으로 타입을 조작할 때 유용합니다.', 4, NOW(), NOW(), 1, 1),
                              (80, 'TypeScript의 타입 호환성(Type Compatibility)이란 무엇인가요?', '타입 호환성은 하나의 타입이 다른 타입으로 간주될 수 있는지 여부를 결정하는 메커니즘입니다. TypeScript는 구조적 타입 시스템을 사용하여 타입 호환성을 검사합니다.', 4, NOW(), NOW(), 1, 1);

        INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                              (81, 'Kotlin의 주요 특징은 무엇인가요?', 'Kotlin은 간결하고, 안전하며, 인터롭 가능성(Java와의 호환성) 및 함수형 프로그래밍을 지원하는 현대적인 언어입니다. Null 안전성과 고급 유형 시스템을 제공하여 코드를 더욱 안정적으로 작성할 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (82, 'Kotlin과 Java의 차이점은 무엇인가요?', 'Kotlin은 간결한 문법, null 안전성, 확장 함수, 그리고 고차 함수와 같은 기능을 지원합니다. Java는 구식 문법과 상대적으로 복잡한 예외 처리가 특징이며, Kotlin은 Java와의 상호 운용성을 제공합니다.', 2, NOW(), NOW(), 1, 1),
                              (83, 'Kotlin에서 Null Safety란 무엇인가요?', 'Null Safety는 Kotlin의 핵심 특징 중 하나로, NullPointerException을 방지하기 위해 변수를 nullable(예: String?) 또는 non-nullable(예: String)로 선언할 수 있게 해줍니다. 이를 통해 컴파일 시점에 null 참조를 미리 방지합니다.', 2, NOW(), NOW(), 1, 1),
                              (84, 'Kotlin의 데이터 클래스(Data Class)란 무엇인가요?', '데이터 클래스는 주로 데이터 보관을 위해 사용되며, equals(), hashCode(), toString()과 같은 메소드를 자동으로 생성합니다. 주 생성자에서 정의된 모든 속성이 데이터 클래스로 인식됩니다.', 2, NOW(), NOW(), 1, 1),
                              (85, 'Kotlin에서 확장 함수(Extension Function)는 어떻게 사용하나요?', '확장 함수는 기존 클래스에 새로운 함수를 추가하는 기능으로, 기존 클래스의 정의를 수정하지 않고도 메소드를 추가할 수 있습니다. 이는 코드의 가독성을 높이고 재사용성을 증대시킵니다.', 2, NOW(), NOW(), 1, 1),
                              (86, 'Kotlin의 Higher-order Function이란 무엇인가요?', '고차 함수는 함수를 매개변수로 받거나 반환하는 함수입니다. Kotlin에서 함수는 일급 시민으로, 다른 함수의 인자로 전달하거나 반환할 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (87, '코틀린의 람다 표현식(Lambda Expression) 사용법은?', '람다 표현식은 간결한 함수 표현 방법으로, 코드 블록을 변수처럼 다룰 수 있게 해줍니다. 이는 주로 고차 함수와 함께 사용되며, 문법이 간단하여 가독성이 좋습니다.', 2, NOW(), NOW(), 1, 1),
                              (88, 'Kotlin에서 var와 val의 차이는 무엇인가요?', 'var는 변경 가능한 변수를 선언할 때 사용하고, val은 변경 불가능한 변수를 선언할 때 사용합니다. val로 선언된 변수는 한 번만 할당할 수 있으며, 재할당이 불가능합니다.', 2, NOW(), NOW(), 1, 1),
                              (89, 'Kotlin의 제네릭(Generics)은 어떻게 동작하나요?', '제네릭은 다양한 데이터 타입을 처리할 수 있게 해주는 기능으로, 함수나 클래스에서 타입을 변수처럼 사용할 수 있게 해줍니다. 이를 통해 코드의 재사용성을 높일 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (90, 'Kotlin에서 sealed class란 무엇인가요?', 'sealed class는 한정된 계층 구조를 나타내며, 주로 상태나 결과를 표현하는 데 사용됩니다. 이 클래스를 상속받는 클래스는 동일한 파일 내에서만 정의할 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (91, 'Kotlin의 Companion Object는 무엇인가요?', 'Companion Object는 클래스와 함께 생성되는 정적 객체로, 클래스의 인스턴스 없이 접근할 수 있는 메소드를 정의할 수 있게 해줍니다. 이를 통해 Java의 static 메소드와 유사한 기능을 수행합니다.', 2, NOW(), NOW(), 1, 1),
                              (92, 'Kotlin에서 스마트 캐스트(Smart Cast)란 무엇인가요?', '스마트 캐스트는 조건문을 통해 변수가 특정 타입인 것을 확인한 후, 해당 타입으로 자동으로 변환하는 기능입니다. 이를 통해 명시적인 타입 변환 없이 안전하게 사용할 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (93, 'Kotlin의 기본 컬렉션 타입은 무엇인가요?', 'Kotlin의 기본 컬렉션 타입은 List, Set, Map입니다. List는 순서가 있는 컬렉션, Set은 중복을 허용하지 않는 컬렉션, Map은 키-값 쌍을 저장하는 컬렉션입니다.', 2, NOW(), NOW(), 1, 1),
                              (94, 'Kotlin에서 코루틴(Coroutine)란 무엇인가요?', '코루틴은 비동기 프로그래밍을 지원하는 Kotlin의 기능으로, 경량 스레드처럼 작동하여 비동기 작업을 더 간단하게 처리할 수 있게 해줍니다. 이는 CPU와 메모리를 효율적으로 사용할 수 있게 해줍니다.', 2, NOW(), NOW(), 1, 1),
                              (95, 'Kotlin의 inline 함수란 무엇인가요?', 'inline 함수는 함수를 호출하는 대신, 컴파일 시점에 해당 함수의 코드를 호출하는 지점에 직접 삽입하는 기능입니다. 이는 성능을 향상시키고 람다 표현식 사용 시 불필요한 객체 생성을 줄입니다.', 2, NOW(), NOW(), 1, 1),
                              (96, 'Kotlin에서 typealias는 어떤 용도로 사용되나요?', 'typealias는 기존 타입에 새 이름을 부여하는 기능으로, 복잡한 타입을 단순화하여 코드 가독성을 높일 수 있습니다. 주로 긴 제네릭 타입을 간단히 표현할 때 유용합니다.', 2, NOW(), NOW(), 1, 1),
                              (97, 'Kotlin에서 destructuring declaration이란 무엇인가요?', 'destructuring declaration은 객체의 속성을 분해하여 변수에 할당하는 방법입니다. 주로 데이터 클래스와 함께 사용되며, 가독성을 높이고 코드를 간결하게 만들 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (98, 'Kotlin의 enum class는 어떻게 정의하나요?', 'enum class는 열거형 타입을 정의하는 데 사용되며, 각 열거형 값은 인스턴스처럼 사용됩니다. 이를 통해 상수 값을 그룹화하고 가독성을 향상시킬 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (99, 'Kotlin에서 lateinit 키워드는 어떻게 사용하나요?', 'lateinit는 nullable이 아닌 변수를 초기화 없이 선언할 수 있도록 해주는 키워드입니다. 나중에 초기화할 것이라는 것을 명시적으로 나타내며, null 검사를 피할 수 있습니다.', 2, NOW(), NOW(), 1, 1),
                              (100, 'Kotlin에서 delegation 패턴은 무엇인가요?', 'delegation 패턴은 다른 객체의 기능을 재사용하는 방법으로, Kotlin에서는 by 키워드를 사용하여 속성의 위임을 쉽게 처리할 수 있습니다. 이를 통해 코드의 재사용성과 유지보수성을 높일 수 있습니다.', 2, NOW(), NOW(), 1, 1);


        INSERT INTO interview_question (id, question, ideal_answer, skill_id, created_at, updated_at, created_by, updated_by) VALUES
                              (101, 'Spring Framework란 무엇인가요?', 'Spring Framework는 Java 플랫폼을 위한 경량의 애플리케이션 프레임워크로, 엔터프라이즈 애플리케이션 개발에 필요한 다양한 기능을 제공합니다. 의존성 주입, AOP, MVC 아키텍처 등을 지원하여 개발자가 쉽게 애플리케이션을 설계하고 구현할 수 있도록 돕습니다.', 6, NOW(), NOW(), 1, 1),
                              (102, 'Spring의 의존성 주입(Dependency Injection) 개념에 대해 설명해주세요.', '의존성 주입은 객체 간의 의존 관계를 코드에서 명시적으로 설정하는 것이 아니라, Spring이 런타임에 자동으로 주입해주는 기술입니다. 이를 통해 객체의 결합도를 낮추고, 테스트와 유지보수가 용이한 코드를 작성할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (103, 'AOP(Aspect Oriented Programming)에 대해 설명해주세요.', 'AOP는 횡단 관심사를 모듈화하여 코드의 분리도를 높이는 프로그래밍 패러다임입니다. 로깅, 보안, 트랜잭션 관리와 같은 기능을 별도의 Aspect로 정의하여 비즈니스 로직과 분리된 형태로 관리할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (104, 'Spring MVC 아키텍처에 대해 설명해주세요.', 'Spring MVC는 Model-View-Controller 패턴을 기반으로 한 웹 프레임워크입니다. Controller가 요청을 처리하고, Model이 데이터 및 비즈니스 로직을 관리하며, View가 사용자에게 표시되는 데이터를 담당합니다. DispatcherServlet이 모든 요청을 처리하는 중앙 집중식 제어기 역할을 합니다.', 6, NOW(), NOW(), 1, 1),
                              (105, 'Spring Boot란 무엇이며, 그 장점은 무엇인가요?', 'Spring Boot는 Spring 프레임워크의 설정을 간소화하여 빠르게 애플리케이션을 개발할 수 있도록 도와주는 도구입니다. 자동 설정, 내장 웹 서버, 스타터 패키지 등의 기능을 제공하여, 복잡한 설정 없이 신속하게 프로젝트를 시작할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (106, 'Spring에서 Bean의 생명주기는 어떻게 관리되나요?', 'Spring에서는 Bean의 생명주기를 초기화, 사용, 소멸의 세 단계로 관리합니다. 개발자는 @PostConstruct와 @PreDestroy 어노테이션을 사용하여 초기화 및 소멸 메서드를 정의할 수 있으며, ApplicationContext에 의해 관리됩니다.', 6, NOW(), NOW(), 1, 1),
                              (107, 'Spring의 트랜잭션 관리(Transaction Management)에 대해 설명해주세요.', 'Spring은 선언적 트랜잭션 관리와 프로그래밍 방식의 트랜잭션 관리 두 가지 방법을 지원합니다. @Transactional 어노테이션을 사용하여 메서드에 트랜잭션 속성을 적용할 수 있으며, 데이터베이스와의 상호작용을 관리합니다.', 6, NOW(), NOW(), 1, 1),
                              (108, 'Spring Security의 기본 개념과 사용 방법은 무엇인가요?', 'Spring Security는 인증 및 권한 부여를 관리하는 프레임워크로, URL 접근 제어, 세션 관리, CSRF 보호 등을 제공합니다. 커스터마이징이 용이하여 다양한 보안 요구 사항을 충족할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (109, 'RESTful API란 무엇이며, Spring에서 어떻게 구현하나요?', 'Spring의 RestTemplate은 RESTful 웹 서비스와 통신하기 위한 클라이언트입니다. GET, POST, PUT, DELETE 메서드를 쉽게 사용할 수 있으며, JSON, XML 등의 데이터 포맷을 지원합니다.', 6, NOW(), NOW(), 1, 1),
                              (110, 'Spring Data JPA란 무엇인가요?', 'Spring Data JPA는 JPA(Java Persistence API)를 기반으로 하여 데이터 접근 계층을 단순화하는 데 사용되는 모듈입니다. 이를 통해 데이터베이스와의 상호작용을 보다 효율적으로 수행할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (111, 'Spring에서 @Autowired 어노테이션의 역할은 무엇인가요?', 'Spring에서 @Autowired 어노테이션은 의존성 주입을 간편하게 설정할 수 있도록 도와줍니다. 필드, 생성자, 메서드에 적용할 수 있으며, Spring이 자동으로 적절한 Bean을 주입합니다.', 6, NOW(), NOW(), 1, 1),
                              (112, 'Spring의 @Component, @Service, @Repository의 차이점은 무엇인가요?', '@Component는 일반적인 컴포넌트를 정의하는 데 사용되며, @Service는 서비스 계층의 컴포넌트를 정의할 때 사용됩니다. @Repository는 데이터 접근 계층의 컴포넌트를 정의하는 데 사용되어, 예외를 데이터 접근 예외로 변환하는 기능을 제공합니다.', 6, NOW(), NOW(), 1, 1),
                              (113, 'Spring에서 Bean Validation은 어떻게 사용하나요?', 'Spring에서는 Bean Validation을 사용하여 입력 값의 유효성을 검사할 수 있습니다. @Valid 어노테이션을 사용하여 검증할 객체를 지정하고, 제약 조건을 정의하여 유효성 검사를 수행합니다.', 6, NOW(), NOW(), 1, 1),
                              (114, 'Spring의 프로파일(Profiles) 기능은 무엇인가요?', 'Spring의 프로파일 기능은 서로 다른 환경에서 애플리케이션을 구분하여 구성할 수 있도록 해줍니다. 이를 통해 개발, 테스트, 운영 환경에 따라 다른 설정을 쉽게 적용할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (115, 'Spring Boot에서 설정 파일(application.properties 또는 application.yml)의 역할은 무엇인가요?', 'Spring Boot에서는 application.properties 또는 application.yml 파일을 통해 애플리케이션 설정 정보를 관리합니다. 이를 통해 다양한 환경에 맞는 설정을 간편하게 적용할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (116, 'Spring에서 @Transactional 어노테이션의 역할은 무엇인가요?', '@Transactional 어노테이션은 메서드가 호출될 때 트랜잭션이 시작되고, 메서드 실행이 완료되면 커밋 또는 롤백됩니다. 이를 통해 데이터의 일관성을 유지할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (117, 'Spring Batch란 무엇인가요?', 'Spring Batch는 대량의 데이터 처리를 위한 프레임워크로, 배치 작업의 실행, 처리 및 모니터링을 지원합니다. 이는 대량의 데이터 입력, 처리, 출력 작업을 효율적으로 관리할 수 있게 해줍니다.', 6, NOW(), NOW(), 1, 1),
                              (118, 'Spring WebFlux란 무엇인가요?', 'Spring WebFlux는 비동기 및 논블로킹 웹 애플리케이션을 개발하기 위한 리액티브 프로그래밍 모델입니다. 이는 데이터 흐름을 기반으로 하여 효율적으로 리소스를 관리할 수 있게 해줍니다.', 6, NOW(), NOW(), 1, 1),
                              (119, 'Spring에서 Exception Handling은 어떻게 처리하나요?', 'Spring에서는 @ControllerAdvice 어노테이션을 사용하여 전역 예외 처리기를 정의할 수 있습니다. 이를 통해 발생하는 예외를 통합적으로 처리하고, 적절한 응답을 클라이언트에게 반환할 수 있습니다.', 6, NOW(), NOW(), 1, 1),
                              (120, 'Spring에서 RESTful 웹 서비스의 버전 관리 방법은 무엇인가요?', 'Spring에서는 URL 경로에 버전 정보를 포함하거나, 요청 헤더를 통해 버전 정보를 관리하여 RESTful 웹 서비스의 버전을 관리할 수 있습니다. 이를 통해 클라이언트와의 호환성을 유지할 수 있습니다.', 6, NOW(), NOW(), 1, 1);
