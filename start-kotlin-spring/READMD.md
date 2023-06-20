# kotlin + spring boot 의 첫발, 구조 분석하기

## Todo List 구현하기

### 도메인 정의

- todo 는 다음 정보를 포함한다
  - id
  - 이름
  - 생성 일시
  - 시작 일시
- todo 는 다음과 같은 상태를 포함한다
  - CREATED
  - IN_PROGRESS
  - DONE
- 사용자는 todo board 를 여러개 가질 수 있다.
- 하나의 todo board 에는 여러개의 todo item 이 존재한다
- 하나의 todo item 은 한 번에 하나의 todo board 에 속해있을 수 있지만 속해있는 todo board 는 변경될 수 있다.

### 제공하는 기능

- command
  - TodoItem 을 생성할 수 있다
  - TodoItem 의 상태를 변경한다
  - TodoItem 이 속해있는 board 를 변경한다
- query
  - 복수의 TodoBoard 를 조회할 수 있다.
  - 단건의 TodoBoard 에 속한 TodoItem 을 상태별로 조회할 수 있다 

### Refs

- [https://spring.io/guides/tutorials/spring-boot-kotlin/](https://spring.io/guides/tutorials/spring-boot-kotlin/)