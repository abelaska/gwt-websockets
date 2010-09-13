/*
 * Copyright 2010 Richard Zschech.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.abelaska.gwt.websockets.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

public class WebSockets implements WebSocketHandler {
	
	public static final int CONNECTING = 0;
	public static final int OPEN = 1;
	public static final int CLOSING = 2;
	public static final int CLOSED = 3;
	
	private TimeoutHandler timeoutHandler;
	private OpenHandler openHandler;
	private CloseHandler closeHandler;
	private ErrorHandler errorHandler;
	private MessageHandler messageHandler;
	
	private int connectTimeout = 5000;
	private int sendTimeout = 5000;
	
	private WebSocket ws;
	private String url;
	
	public WebSockets() {
	}
	
	public void open(String url) {
		this.url = url;
		
		Timer t = new Timer() {
	      public void run() {
	          Window.alert("Open timeout");
	      }
	    };

		try {
			t.schedule(connectTimeout);
			this.url = url;
			this.ws = WebSocket.create(url);
			this.ws.setHandler(this);
			t.cancel();
		}
		catch (Exception e) {
			t.cancel();
			e.printStackTrace();
			//errorHandler.onError(this.ws, e);
		}
	}
	
	public final void close() {
		if (this.ws != null) {
			this.ws.close();
		}
	};

	public final void setOnTimeout(TimeoutHandler handler) {
		this.timeoutHandler = handler;
	};
	
	public final void setOnOpen(OpenHandler handler) {
		this.openHandler = handler;
	};
	
	public final void setOnClose(CloseHandler handler) {
		this.closeHandler = handler;
	};

	public final void setOnError(ErrorHandler handler) {
		this.errorHandler = handler;
	};
	
	public final void setOnMessage(MessageHandler handler) {
		this.messageHandler = handler;
	}

	@Override
	public void onClose(WebSocket webSocket) {
		Window.alert("Closed");
		if (closeHandler != null) {
			closeHandler.onClose(this.ws);
		}
		this.ws = null;
	}

	@Override
	public void onOpen(WebSocket webSocket) {
		Window.alert("Opened");
		
	}

	@Override
	public void onError(WebSocket webSocket) {
		Window.alert("Error");
		
	}

	@Override
	public void onMessage(WebSocket webSocket, MessageEvent event) {
		Window.alert("Message");
		
	}
}
