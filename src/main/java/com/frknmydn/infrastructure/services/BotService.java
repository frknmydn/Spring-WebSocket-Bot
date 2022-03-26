package com.frknmydn.infrastructure.services;

import com.frknmydn.infrastructure.abstractions.services.IBotService;
import com.frknmydn.infrastructure.abstractions.services.ISentenceService;
import com.frknmydn.springbootwebsocket.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class BotService implements IBotService {

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Autowired
    private ISentenceService _sentenceService;

    @Override
    public void SendMessage() {
        ChatMessage botMessage = new ChatMessage();
        botMessage.setSender("Bot");
        botMessage.setType(ChatMessage.MessageType.CHAT);

        int random_i = (int)(Math.random() * this._sentenceService.getAllSentences().size());
        botMessage.setContent(this._sentenceService.getAllSentences().get(random_i));

        webSocket.convertAndSend("/topic/public", botMessage);
    }
}
