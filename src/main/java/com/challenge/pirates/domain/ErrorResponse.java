package com.challenge.pirates.domain;

import java.io.IOException;
import java.util.Properties;

public class ErrorResponse extends JsonResult{

	private static final String ERROR_FILE = "errorCodes.properties";
	
	private int internal_code;
	private String message;
	
	
	
	public ErrorResponse(String code) {
		super();
		
		this.internal_code = Integer.parseInt(code);
		
		Properties prop = new Properties();
		try {
			prop.load(ErrorResponse.class.getClassLoader().getResourceAsStream(ERROR_FILE));
			this.message = prop.getProperty(code);
		} catch (IOException e) {
			this.message = "Error loading " + ERROR_FILE + ": " + e.getMessage();
		}
		
		
		
	}

	public int getInternal_code() {
		return internal_code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + internal_code;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		if (internal_code != other.internal_code)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorResponse [internal_code=" + internal_code + ", message=" + message + "]";
	}
	
	
}
