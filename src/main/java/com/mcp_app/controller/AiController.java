package com.mcp_app.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    public AiController(ChatClient.Builder builder) {
        this.chatClient = builder.
                defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    private ChatClient chatClient;

    public ResponseEntity<String> getResponse(@RequestParam("query") String query){

        String response = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(response);
    }
}
