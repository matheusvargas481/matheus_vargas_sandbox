package com.poc.pockafkaprodutor.dto;

public class Message {

	private String message;

	public Message() {
		super();
	}

	public Message(final String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
