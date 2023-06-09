package com.heiqi.chat.WebSocketChat;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ServerEndpoint(value = "/api/webSocket/{from}/{to}")
@Component
public class WebSocketServer {
    private static Logger L = LoggerFactory.getLogger(WebSocketServer.class);

    private static List<SessionWarp> sessionList = new ArrayList<>();

    private String from;

    private String to;
    //链接建立成功。。。。。

    @OnOpen
    public void onOpen(Session session, @PathParam("from") String from, @PathParam("to") String to) {
        this.from = from;
        this.to = to;
        for (SessionWarp item : sessionList) {
            if (item.getFrom().equals(from) && item.getTo().equals(to)) {
                item.setSession(session);
                item.setLastTime(new Date());
                return;
            }
        }
        SessionWarp sessionWarp = new SessionWarp();
        sessionWarp.setFrom(from);
        sessionWarp.setTo(to);
        sessionWarp.setSession(session);
        sessionWarp.setLastTime(new Date());
        sessionList.add(sessionWarp);

    }

    //链接关闭。。。。。。
    @OnClose
    public void onClose() {
        List<SessionWarp> newSessionList = new ArrayList<>();
        for (SessionWarp item : sessionList) {
            if (item.getFrom().equals(from) && item.getTo().equals(to)) {
                continue;
            }
            newSessionList.add(item);
        }
        sessionList = newSessionList;
    }

    //接收消息。。。。。。。。

    @OnMessage
    public void onMessage(String message, Session session) {
        //发送到对方
        try {
            for (SessionWarp item : sessionList) {
                if (item.getFrom().equals(to) && item.getTo().equals(from)) {
                    item.getSession().getBasicRemote().sendText(message);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
