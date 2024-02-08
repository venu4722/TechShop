package com.hexaware.exception;

@SuppressWarnings("serial")
public class IncompleteOrderException extends Exception {
	public IncompleteOrderException(String msg) {
		super(msg);
	}
}
