package com.app.models;

public class UniqueChars {
	private final long id;
	private final String line;
	private final boolean hasUniqueChars;
	
	public UniqueChars(long id, String line, boolean hasUniqueChars){
		this.id = id;
		this.line = line;
		this.hasUniqueChars = hasUniqueChars;
	}
	
	public long getId(){
		return this.id;
	}
	public String getLine(){
		return this.line;
	}
	public boolean getHasUniqueChars(){
		return this.hasUniqueChars;
	}
}
