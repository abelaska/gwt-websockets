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

public class WebSocket extends JavaScriptObject {
	
	public static final int CONNECTING = 0;
	public static final int OPEN = 1;
	public static final int CLOSING = 2;
	public static final int CLOSED = 3;
	
	/**
	 * Creates an WebSocket object.
	 * 
	 * @return the created object
	 */
	public static native WebSocket create(String url) /*-{
		return new $wnd.WebSocket(url);
	}-*/;
	
	public static native WebSocket create(String url, String protocol) /*-{
		return new $wnd.WebSocket(url, protocol);
	}-*/;

	protected WebSocket() {
	}
	
	public final native int getReadyState() /*-{
		return this.readyState;
	}-*/;
	
	public final native int getBufferedAmount() /*-{
		return this.bufferedAmount;
	}-*/;

	public final native void send(String data) /*-{
		this.send(data);
	}-*/;
	
	public final native void close() /*-{
		this.close();
	}-*/;
	
	public final native void setHandler(WebSocketHandler handler) /*-{
		// The 'this' context is always supposed to point to the websocket object in the
		// onreadystatechange handler, but we reference it via closure to be extra sure.
		var _this = this;
		this.onopen = $entry(function() {
			handler.@com.github.abelaska.gwt.websockets.client.WebSocketHandler::onOpen(Lcom/github/abelaska/gwt/websockets/client/WebSocket;)(_this);
		});
		this.onclose = $entry(function() {
			handler.@com.github.abelaska.gwt.websockets.client.WebSocketHandler::onClose(Lcom/github/abelaska/gwt/websockets/client/WebSocket;)(_this);
		});
		this.onerror = $entry(function() {
			handler.@com.github.abelaska.gwt.websockets.client.WebSocketHandler::onError(Lcom/github/abelaska/gwt/websockets/client/WebSocket;)(_this);
		});
		this.onmessage = $entry(function(event) {
			handler.@com.github.abelaska.gwt.websockets.client.WebSocketHandler::onMessage(Lcom/github/abelaska/gwt/websockets/client/WebSocket;Lcom/github/abelaska/gwt/websockets/client/MessageEvent;)(_this, event);
		});
	}-*/;
}
