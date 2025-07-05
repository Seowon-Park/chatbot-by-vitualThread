<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual Threads 챗봇</title>
    <link rel="stylesheet" href="/css/chatbot.css">
</head>
<body>
<div class="chat-container">
    <h1>챗봇 시스템</h1>
    <p>JDK 21 Virtual Threads + Spring Boot 3.2로 구동</p>

    <div class="chat-messages" id="chatMessages">
        <div class="message bot-message">
            안녕하세요! 무엇을 도와드릴까요?
        </div>
    </div>

    <form class="input-container" onsubmit="sendChat(event)">
        <input type="text" id="msg" placeholder="메시지를 입력하세요..." required />
        <button type="submit" id="sendBtn">전송</button>
    </form>
</div>

<script src="/js/chatbot.js"></script>
</body>
</html>