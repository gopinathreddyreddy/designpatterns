package com.design.patterns.behavioral.observer;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageStream extends Subject {

	private Deque<String> messageHistory = new ArrayDeque();
	
	void setState(String message) {
		messageHistory.add(message);
		this.notifyObservers();
	}

	String getState() {
		return messageHistory.getLast();
	}
}
