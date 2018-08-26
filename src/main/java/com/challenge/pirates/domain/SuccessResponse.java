package com.challenge.pirates.domain;

import java.io.IOException;

public class SuccessResponse extends JsonResult{

	private String message;
	
	public SuccessResponse(){
		super();
		}
	
	public SuccessResponse(String message) throws IOException {
		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		SuccessResponse other = (SuccessResponse) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuccessResponse [message=" + message + "]";
	}

	
	
}
