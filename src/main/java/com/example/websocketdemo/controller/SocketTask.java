package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocketTask {

    private SimpMessagingTemplate template;

    @Autowired
    public SocketTask(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/hello")
    public void greeting(Request request) throws Exception {
        String url2 = "/topic/chat/"+request.getRoom();
        Thread.sleep(1000);
        this.template.convertAndSend(url2, request);
    }
}
