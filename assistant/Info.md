## *.jar
- *.jar -> boot jar으로 애플리케이션으로 띄울 수 있는 jar
- plain.jar -> 순수 애플리케이션?


## 테스트 빌드
- ./gradlew clean test --info : 테스트 후 clean하면 libs가 사라짐
- ./gradlew build : 빌드
- ./gradlew clean build --info

## 실행방법
java jar {filename}.jar

## keypair 저장
- 로컬 ~/.ssh/ 경로에 저장
- 권한 변경 chmod 600 interview-key-pair.pem 

## ec2 server 실행
- ssh -i ~/.ssh/mock-interview-key-pair.pem ec2-user@3.38.178.21

## 원격지로 파일 전송 방법
- scp
- rsync (고급기능)