package com.hexaware.exception;

@SuppressWarnings("serial")
public class InsufficientStockException extends Exception{
	public InsufficientStockException(String msg) {
		super(msg);
	}
}
