package com.github.abelaska.gwt.websockets;

// based on class from project http://github.com/ImJasonH/websocket-gwt

public class WebSocketClient {

	public interface WebSocketCallback {
		public void onOpen();

		public void onMessage(String message);

		public void onClose();
	}

	final WebSocketCallback callback;

	/**
	 * Constructs a WebSocketClient with which you can interact with a WebSocket
	 * server.
	 * 
	 * @param callback
	 *          to handle incoming messages from the WebSocket server.
	 */
	public WebSocketClient(WebSocketCallback callback) {
		this.callback = callback;
	}

	@SuppressWarnings("unused")
	// called by native code to call the callback on socket open.
	private void onopen() {
		callback.onOpen();
	}

	@SuppressWarnings("unused")
	// called by native code to call the callback on socket close.
	private void onclose() {
		callback.onClose();
	}

	@SuppressWarnings("unused")
	// called by native code to call the callback on incoming messages.
	private void onmessage(String msg) {
		callback.onMessage(msg);
	}

	/**
	 * @return whether or not WebSockets are supported by the browser.
	 */
	public static native boolean isSupported() /*-{
		return typeof $wnd.WebSocket != "undefined";
	}-*/;

	/**
	 * Connect to a WebSocket server at the given address.
	 * 
	 * @param server
	 *          address of the server to connect to. (e.g., "ws://localhost:9876")
	 */
	public native void connect(String server) /*-{
		if (this._ws) {
			alert("Already connected!");
		}
		var self = this;
		self._ws = new WebSocket(server);
		self._ws.onopen = function(e) {
			console.log("Connecting to websocket");
			self.@com.imjasonh.websocket.client.WebSocketClient::onopen() ();
		};
		self._ws.onmessage = function(e) {
			console.log("Received websocket message: " + e.data);
			if (e.data) {				
				self.@com.imjasonh.websocket.client.WebSocketClient::onmessage(Ljava/lang/String;) (e.data);
			}
		};
		self._ws.onclose = function(e) {
			console.log("Websocket closed");
			self.@com.imjasonh.websocket.client.WebSocketClient::onclose() ();
			delete self._ws;
		};
	}-*/;

	/**
	 * Send a message to the WebSocket server.
	 * 
	 * @param msg
	 *          the message to send.
	 */
	public native void send(String msg) /*-{
		if (this._ws) {
			console.log("Sending message: " + msg);
			this._ws.send(msg);
		} else {
			alert("Not connected!");
		}
	}-*/;

	/**
	 * Close the existing connection to the WebSocket server.
	 */
	public native void close() /*-{
		if (this._ws) {
			console.log("Closing websocket");
			this._ws.close();
			this._ws = null;
		} else {
			alert("Not connected!");
		}
	}-*/;
}
