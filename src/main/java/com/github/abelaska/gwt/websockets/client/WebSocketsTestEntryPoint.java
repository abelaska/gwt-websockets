package com.github.abelaska.gwt.websockets.client;

import com.google.gwt.core.client.EntryPoint;

public class WebSocketsTestEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		WebSockets ws = new WebSockets();
//		ws.open("ws://127.0.0.1:10081");
//		ws.close();
		WebSocket ws = WebSocket.create("ws://127.0.0.1:10081");
		ws.setHandler(new WebSocketHandler() {
			
			@Override
			public void onOpen(WebSocket webSocket) {
				webSocket.send("ahoj2");
			}
			
			@Override
			public void onMessage(WebSocket webSocket, MessageEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(WebSocket webSocket) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClose(WebSocket webSocket) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
