# 퍼스널면접코치 (my-interview-coach)

## 서비스 링크
https://myinterviewscoach.com/

## 아이디어 시작점

개인 타겟으로 로그인이 필요하지 않은 가벼운 기능과 로그인을 해야하는 기능을 분리한다. 

로그인이 필요하지 않은 기능은 재미를 끌어 모으거나, “삼쩜삼”같은 간편하면서 유용한 정보를 빠르게 제공하는 것을 목표로 한다.

## 나만의 면접 트레이너 - 모의면접 플랫폼 (삼쩜삼같은 심플하고 감각적인 디자인)

### 프로세스

초안 : https://docs.google.com/presentation/d/1_bKHDDND6v_rpk9sLWijNcUUwraET62iK1uKaeJfshY/edit?usp=sharing

프로세스(진행중)

[프로세스 및 요구사항 정리](https://www.notion.so/4212561f684e42c7b40a1a125cf5bc66?pvs=21)

### 아이디어 정리

**로그인 필요 X**

- 모의면접자가 직무를 선택하면 “면접 시작 팝업” 노출
- 질문에 답을 작성하는 텍스트박스와 녹음 기능을 통해 스스로 면접 진행
    - 로그인하지 않을 경우 정답은 제공하지 않음 → 정답보기를 클릭하면 로그인팝업
    - 직무별 면접 예상질문과 정답을 DB에 저장
    - 텍스트박스에 입력한 후 저장하면 질의응답에 대한 데이터 확인가능 (유료 : 데이터 다운로드 가능)
    - 탑티어 개발자 섭외해서 코멘트 요청
- 녹음 기능 제공 → 재생만 가능 (유료 : 녹음본 다운로드 가능)
- 질의응답 보기 기능 제공 → 유료버전에서 다운로드 가능

**로그인 혹은 요금제 결제 시**

- 모의면접 with ChatGPT
    - 면접 진행 중 질문에 대한 흰트, 정답과 ChatGPT 코멘트 제공
    - 녹음 기능 제공 → 재생, 다운로드 가능
        - 엑셀보다는,,,마크업 형태로 추출 && PDF 등 제공 방법 고민해보기
    - 면접 질의응답 데이터, chatgpt 피드백과 함께 다운로드 가능

### 발전 방향성

### Pramp와 같은 peer to peer 플랫폼

- https://www.pramp.com/#/
- 외국에서 정말 많이 활용되는 플랫폼인데, 현재 국내엔 존재하지 않음
- 일반 개발자와 하는 라이브 모의 코딩 인터뷰는 무료
- FAANG과 같은 멘토와 함께하는 라이브 모의 코딩 인터뷰는 부분 유료

## 기술 스택

기획 : 미정

Design : 미정

Frontend : Vue.js 3v, Javascript

Backend : Java 17 * SpringBoot 3.3.0

Infra : AWS DynamoDB, AWS S3, AWS EC2

## AS-IS 배포 방법
- assistant-frontend
    - npm run build
    - backend resources 하위에 static 디렉토리 생성 및 덮어쓰기
- assistant-backend
    - gradle build
    - AWS 서버로 jar 파일 이동
        - scp -i ~/.ssh/mock-interview-key-pair.pem assistant-0.0.1-SNAPSHOT.jar ec2-user@{aws-ip}:/home/ec2-user
- AWS
    - ps -ef | grep java 
        - 실행중인 어플리케이션 kill
    - nohup java -jar assistant-0.0.1-SNAPSHOT.jar &
    - 로그보는 방법
        - /opt/assistant/log/catalina
            - tail -f -n {row numbers} {file_name} -> 실시간 모니터링
            - less {file_name} -> 트러블슈팅
                - grep으로 문자열 검색