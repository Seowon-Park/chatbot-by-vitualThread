package com.mywork.vtchatbot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Controller
public class ChatController {

    // 메인 페이지 반환 (Model 객체 추가로 향후 데이터 전달 가능)
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Virtual Threads 챗봇");
        model.addAttribute("version", "1.0.0");
        return "index";
    }

    private final Executor virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();

    // 챗봇 API 엔드포인트 (Virtual Threads 활용)
    @PostMapping("/chatbot")
    @ResponseBody
    public CompletableFuture<ResponseEntity<String>> chatbot(@RequestBody Map<String, String> request) {
        String message = request.get("message");

        // Virtual Threads를 사용한 비동기 처리
        return CompletableFuture.supplyAsync(() -> {
            try {
                // 여기서 LangChain API 서버로 요청을 보내는 로직을 구현
                String response = callLangChainAPI(message);
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.internalServerError()
                        .body("오류가 발생했습니다: " + e.getMessage());
            }
        });
    }

    // 향후 폼 기반 요청 처리용 (Spring MVC 패턴)
    @PostMapping("/chat")
    public String handleChatForm(@RequestParam String message, Model model) {
        try {
            String response = callLangChainAPI(message);
            model.addAttribute("userMessage", message);
            model.addAttribute("botResponse", response);
        } catch (Exception e) {
            model.addAttribute("error", "오류가 발생했습니다: " + e.getMessage());
        }
        return "index";
    }

    // LangChain API 서버 호출 메서드
    private String callLangChainAPI(String message) {
        RestTemplate restTemplate = new RestTemplate();
        String flaskUrl = "http://localhost:5000/chat";
        Map<String, String> requestBody = Map.of("message", message);
        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(flaskUrl, requestBody, Map.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                Map<String, Object> body = response.getBody();
                return (String) body.get("response");
            } else {
                return "LangChain API 호출 실패: 상태 코드 " + response.getStatusCode();
            }
        } catch (Exception e) {
            return "LangChain API 호출 중 예외 발생: " + e.getMessage();
        }
    }
}