package com.itomas.dropwizard.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PalindromeSuccess implements Palindrome{

	private boolean isPalindrome;
	public PalindromeSuccess() {
	}
	public PalindromeSuccess(boolean isPalindrome) {
		this.isPalindrome = isPalindrome;
	}
	@JsonProperty(value="isAPalindrome")
	public boolean isAPalindrome() {
		return isPalindrome;
	}
	
}
