package com.heiqi.chat.WebSocketChat;

import jakarta.websocket.Session;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class SessionWarp {
    private String from; // 会话的发起者id
    private String to; //会话的接收者id
    private Session session;
    private Date lastTime;//最近的使用时间



}
