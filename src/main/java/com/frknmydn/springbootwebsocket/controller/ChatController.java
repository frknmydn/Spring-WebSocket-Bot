package com.frknmydn.springbootwebsocket.controller;

import com.frknmydn.infrastructure.abstractions.services.IBotService;
import com.frknmydn.infrastructure.abstractions.services.ISentenceService;
import com.frknmydn.springbootwebsocket.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate webSocket;
    @Autowired
    private IBotService _botService;


    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    public void sendMessage(@Payload ChatMessage chatMessage)
    {
        webSocket.convertAndSend("/topic/public", chatMessage);
        _botService.SendMessage();
    }


}