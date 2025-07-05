### Mini project[Spring Boot/JDK21-Virtual Thread] 
2025.06 -
# 쇼핑몰 웹사이트

### 프로젝트 소개
1. <br/>
2. <br/>
3. <br/>

### 제작 목적
<br/>

### 기술스택
● 백엔드 프레임워크: SpringBoot<br/>
● JDK 버전: JDK 21(Virtual Thread 기능 활용)<br/>
● AI 서버: Flask=<br/>
● AI 모델 및 프레임워크 : OpenAI + LangChain (LLM 응답 흐름 제어 및 프롬프트 체인 구성)<br/>
*Flask: Python기반 REST API 서버. 경량<br/>
*LangChain: LLM오케스트레이션 프레임워크(OpenAI의 GPT API를 연결하고, 프롬프트 체인, Tool 연결, 메모리 관리 등 지원)<br/>

## 개인 서버 관련 고민..<br/>
JDK21는 스프링6이랑 호환성o, 톰캣10 이상에서 안정적으로 동작.<br/>
서버 환경(라즈베리파이3+): 톰캣9, 스프링5까지가 최대 => 최신 스택 적용 어려움.<br/>
## 해결 방안...<br/>
스프링 부트 기반으로 코드작성but(서버 사양 업그레이드 대비)스프링6으로 마이그레이션할 수 있도록 코드 작성.<br/>
+라즈베리파이에서는 도커 사용 고려 중.<br/>

### 블로그 기록
<a href="https://codetails.tistory.com/23">[동시 요청 처리(Langchain활용 챗봇 구현) | JDK21-Virtual Thread]<br/>
