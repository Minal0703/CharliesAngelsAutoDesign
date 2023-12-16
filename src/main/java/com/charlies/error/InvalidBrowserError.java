package com.jarvis.errors;

public class InvalidBrowserError extends Error{
	
	public String browsername;
	
	public InvalidBrowserError(String browsername)
	{
		this.browsername= browsername;
	}
	
	public String getMessage() {
		return ("Invalid browser name"+ browsername);

	}

}
