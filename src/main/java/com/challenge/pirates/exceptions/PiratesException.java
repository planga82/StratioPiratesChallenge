package com.challenge.pirates.exceptions;

public class PiratesException extends Exception {


	private static final long serialVersionUID = -7939385312610683167L;

	public PiratesException() {
	}

	public PiratesException(String message) {
		super(message);
	}

	public PiratesException(Throwable cause) {
		super(cause);
	}

	public PiratesException(String message, Throwable cause) {
		super(message, cause);
	}

	public PiratesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
