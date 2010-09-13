package com.github.abelaska.gwt.websockets.client;

public interface WebSocketHandler {

	  /**
	   * This is called whenever the state of the WebSocket changes. See
	   * {@link WebSocket#setOnOpen}.
	   * 
	   * @param webSocket the object which has been opened.
	   */
	  public void onOpen(WebSocket webSocket);
	
	  /**
	   * This is called whenever the state of the WebSocket changes. See
	   * {@link WebSocket#setOnCloseHandler}.
	   * 
	   * @param webSocket the object which has been closed.
	   */
	  public void onClose(WebSocket webSocket);

	  /**
	   * This is called whenever the state of the WebSocket changes. See
	   * {@link WebSocket#setOnErrorHandler}.
	   * 
	   * @param webSocket the object which has been closed.
	   */
	  public void onError(WebSocket webSocket);

	  /**
	   * This is called whenever the state of the WebSocket changes. See
	   * {@link WebSocket#setMessageHandler}.
	   * 
	   * @param webSocket the object which has received a message.
	   */
	  public void onMessage(WebSocket webSocket, MessageEvent event);
}
