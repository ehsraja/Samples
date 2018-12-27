package com.rhl.service.webSocket;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {
	
	 @Override
	    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
	        System.out.println("Connected!");
	        StompFrameHandler handler = new StompFrameHandler() {
	            @Override
	            public Type getPayloadType(StompHeaders stompHeaders) {
	                return null;
	            }

	            @Override
	            public void handleFrame(StompHeaders stompHeaders, Object o) {
	                System.out.println("received " + o.toString());
	            }
	        };
	 }

}
