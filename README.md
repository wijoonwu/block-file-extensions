# block-file-extensions
<br>

<img src="https://user-images.githubusercontent.com/57162810/225782939-63662807-1a43-4708-8c2b-5c3dbe9d41ca.png" height="300" width="400">


## 프로젝트 설치

### MacOS
1. 터미널을 열고 아래 명령어를 입력합니다.

```bash
git clone https://github.com/wijoonwu/block-file-extensions
cd block-file-extensions
./gradlew bootRun
```
2. 웹브라우저를 열고 `localhost:8080`에 접속합니다.

### Windows
1. git bash 창에 아래 명령어를 입력합니다.
```bash
git clone https://github.com/wijoonwu/block-file-extensions
cd block-file-extensions
gradlew bootRun
```

2. 웹브라우저를 열고 `localhost:8080`에 접속합니다.

<br>


## 프로젝트 정보
### ERD

<img width="628" alt="스크린샷 2023-03-17 오후 12 19 59" src="https://user-images.githubusercontent.com/57162810/225804264-7e348273-a9dc-4528-9f5d-cb2888715cca.png">

### 디렉터리 구조
~~~
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.flow.file
│   │   │   │   ├── biz
│   │   │   │   │   ├── entity
│   │   │   │   │   ├── repository
│   │   │   │   │   └── service
│   │   │   │   └── web
│   │   │   │       ├── controller
│   │   │   │       └── dto
│   │   ├── resources
│   │   │   ├── static
│   │   │   │   ├── css
│   │   │   │   └── js
│   │   │   └── templates
│   └── test
│       ├── java
│       │   └── com.flow.file
│       │       └── service
│       └── resources
├── .gitignore
├── build.gradle
└── README.md
~~~


## 기술 스택
### 백엔드
- Java 17
- Spring Boot 3.0.4
- Spring Web MVC
- Spring Data JPA
- Lombok
- H2 In-Memory Database
### 프론트엔드
- HTML5
- CSS3
- JavaScript
- jQuery 3.4.1
- Font Awesome
- Mustach
### 개발 환경 및 도구
- MacOS
- IntelliJ IDEA
- Git
- Gradle 7.6.1

### 배포 및 인프라
- nginx 1.22.1
- Amazon Web Services
  - EC2
  - ACM (AWS Certificate Manager)
  - Application Load Balancer
  - Route 53
