package com.example.market.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import com.example.market.dto.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MarketWebSocketClient implements WebSocketHandler {
	@Autowired
	private WebSocketClient webSocketClient;
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${market.ws.url}")
	private String marketWsUrl;
	
	@PostConstruct
	public void init() {
		webSocketClient.doHandshake(this, marketWsUrl);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("Connected to the market!");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		var payload = message.getPayload().toString();
		var trade = mapper.readValue(payload, Trade.class);
		System.err.println(trade);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.err.println(exception.getMessage());
	
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.err.println("Connection is closed!");
		
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
