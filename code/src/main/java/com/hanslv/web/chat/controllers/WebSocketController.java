package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.component.WebSocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author pc
 */
@RestController
@RequestMapping("/webSocket")
public class WebSocketController {

    @Resource
    private WebSocket webSocket;

    @GetMapping("/sentMessage")
    public void sentMessage(String userId,String message){
        try {
            webSocket.sendMessageByUserId(userId,message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
