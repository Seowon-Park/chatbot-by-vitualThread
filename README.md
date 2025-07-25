### Mini project[Spring Boot/JDK21-Virtual Thread] 
2025.06 -
# 가상 스레드 적용 LangChain 챗봇 웹페이지

## 프로젝트 소개
1. 대규모 동시 요청 처리를 위해가상 스레드를 적용한다.<br/>
2. LangChain을 활용한 챗봇 시스템을 설계 및 구현한다.<br/>
3. 챗봇 서비스를 위한 웹페이지를 제작한다.<br/>

## 제작 목적
다수의 동시 접속이 예상되는 챗봇 사무 처리 환경에 대비해 효율적인 처리를 위해 가상스레트를 적용한 프로젝트를 진행함<br/>

## 기술스택
● 백엔드 프레임워크: SpringBoot<br/>
● JDK 버전: JDK 21(Virtual Thread 기능 활용)<br/>
● AI 서버: Flask<br/>
● AI 모델 및 프레임워크 : OpenAI + LangChain (LLM 응답 흐름 제어 및 프롬프트 체인 구성)<br/>
*Flask: Python기반 REST API 서버. 경량<br/>
*LangChain: LLM오케스트레이션 프레임워크(OpenAI의 GPT API를 연결하고, 프롬프트 체인, Tool 연결, 메모리 관리 등 지원)<br/>

### 개인 서버 관련 고민..<br/>
JDK21는 스프링6이랑 호환성o, 톰캣10 이상에서 안정적으로 동작.<br/>
서버 환경(라즈베리파이3+): 톰캣9, 스프링5까지가 최대 => 최신 스택 적용 어려움.<br/>
### 해결 방안...<br/>
스프링 부트 기반으로 코드작성but(서버 사양 업그레이드 대비)스프링6으로 마이그레이션할 수 있도록 코드 작성.<br/>
+현재 라즈베리파이에서는 도커 사용 고려 중.<br/>

### 블로그 기록
<a href="https://codetails.tistory.com/23">[동시 요청 처리(Langchain활용 챗봇 구현) | JDK21-Virtual Thread]<br/>


### 현재 후속 프로젝트로 챗봇(txt문서=>백터DB화) 구현, 웹페이지 고도화 진행 중
https://github.com/Seowon-Park/ChatBot_pj2<br/>
https://github.com/Seowon-Park/ChatBot_pj2_AI<br/>
