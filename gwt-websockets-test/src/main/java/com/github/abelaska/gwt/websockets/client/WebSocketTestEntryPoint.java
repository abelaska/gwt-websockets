package com.github.abelaska.gwt.websockets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class WebSocketTestEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		WebSocket ws = WebSocket.create("ws://127.0.0.1:10081");
		ws.setHandler(new WebSocketHandler() {
			
			@Override
			public void onOpen(WebSocket webSocket) {
				Window.alert("open");
				webSocket.send("ahoj2");
			}
			
			@Override
			public void onMessage(WebSocket webSocket, MessageEvent event) {
				Window.alert("message: " + event.getData());
			}
			
			@Override
			public void onError(WebSocket webSocket) {
				Window.alert("error");
			}
			
			@Override
			public void onClose(WebSocket webSocket) {
				Window.alert("close");
			}
		});
	}
}
