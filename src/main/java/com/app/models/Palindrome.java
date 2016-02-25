package com.app.models;

public class Palindrome {
	private final long id;
	private final String line;
	private final boolean isPalindrome;
	
	public Palindrome(long id, String line, boolean isPalindrome){
		this.id = id;
		this.line = line;
		this.isPalindrome = isPalindrome;
	}

	public long getId() {
		return id;
	}

	public String getLine() {
		return line;
	}

	public boolean getIsPalindrome() {
		return isPalindrome;
	}
}
