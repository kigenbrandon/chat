package com.example.chat.chat.config;

import com.example.chat.chat.ChatMessage;
import com.example.chat.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    public  final SimpMessageSendingOperations messageSendingOperations;
    public void handleWebSocketDisconnectListener(
            SessionDisconnectEvent event
    ) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("User disconnected: {}",username);
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public", chatMessage);
        }
    }
}
