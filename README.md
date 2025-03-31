# Java Backend Engineer Assignment

## 구현 범위

이 프로젝트는 과제 요구사항에 따른 내용을 도메인(Brand, Category, Product)별로 분리된 구조로 구현하였습니다.

각 도메인은 아래와 같이 세부 패키지로 구성되어 있습니다.

- **entity**: 도메인 모델(Brand, Category, Product) 정의
- **repository**: 데이터베이스 접근 계층(Querydsl, JPA)
- **dto**: Controller와 Service 간의 데이터 전송 객체
- **service**: 도메인 비즈니스 로직 구현 (자신의 Repository만 직접 참조하며, 다른 도메인의 데이터는 해당 도메인의 Service를 호출)
- **controller**: REST API 엔드포인트 제공 (요청/응답은 모두 DTO로 주고받음)
- **exception**: 도메인별 Custom Exception 및 Global Exception Handler

### 제공 API

1. **카테고리별 최저가격 조회 API**
    - 각 카테고리(상의, 아우터, 바지, 스니커즈, 가방, 모자, 양말, 액세서리)별 최저가격과 해당 브랜드 정보를 조회하고, 총액을 계산합니다.

2. **단일 브랜드 구매 시 최저 총액 조회 API**
    - 단일 브랜드로 모든 카테고리의 상품을 구매할 경우의 총액 및 해당 브랜드의 각 카테고리 상품 가격을 반환합니다.

3. **특정 카테고리의 최저/최고 가격 조회 API**
    - 입력받은 카테고리의 최저/최고 가격 및 해당 브랜드 정보를 조회합니다.

4. **CRUD API**
    - **Brand**: 브랜드 생성, 수정, 삭제
    - **Category**: 카테고리 생성, 조회, 수정, 삭제
    - **Product**: 상품 생성, 조회, 수정, 삭제

### API 명세

> API의 상세 명세는 Swagger를 통해 제공되며, 서버 기동 후
> 브라우저에서 [http://localhost:8080/api-docs.html](http://localhost:8080/api-docs.html)로 접근할 수 있습니다.

## 빌드, 테스트 및 실행 방법

### 빌드 및 테스트

- **빌드**:
  ```bash
  ./gradlew clean build
  ```

- **테스트**:
  ```bash
  ./gradlew test
  ```

### 실행

애플리케이션 실행 시 Flyway가 `src/main/resources/db/migration` 폴더의 마이그레이션 스크립트(V1__init.sql)를 실행하여 H2 인메모리 데이터베이스를 초기화합니다.

- **실행**:
  ```bash
  ./gradlew bootRun
  ```

애플리케이션이 실행되면, Swagger를 통해 API 문서를 [http://localhost:8080/api-docs.html](http://localhost:8080/api-docs.html)에서 확인할 수
있습니다.  
또한, H2 콘솔은 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)에서 접근 가능합니다.

## 기타 추가 정보

- **패키지 구조**:

  각 도메인은 `brand`, `category`, `product`라는 최상위 패키지로 분리되어 있으며, 각 패키지 하위에 `entity`, `repository`, `dto`, `service`,
  `controller`, `exception` 패키지가 존재합니다.  
  이를 통해 도메인 간 의존성을 최소화하고, 관심사의 분리를 명확히 하였습니다.

- **BigDecimalCommaSerializer 처리**:

  `BigDecimal` 타입으로 저장되어있는 가격 정보를 한국식 가격 정보인 따옴표로 구분되어있는 문자열 형식으로 반환하기 위하여 `NumberFormat`을 적용하는 `Jackson Simple Module`을
  사용합니다.

- **Exception 처리**:

  각 도메인별 Custom Exception(예: BrandNotFoundException, CategoryNotFoundException, ProductNotFoundException)을 사용하며, Global
  Exception Handler가 일관된 JSON 형식의 응답(CommonResponse)을 반환합니다.

- **Querydsl & Lombok**:

  복잡한 쿼리는 Querydsl로 구현되었으며, Lombok을 통해 보일러플레이트 코드를 최소화하였습니다.

- **Flyway**:

  데이터베이스 초기화는 Flyway를 통해 관리되며, `src/main/resources/db/migration/V1__init.sql` 스크립트를 사용합니다.
