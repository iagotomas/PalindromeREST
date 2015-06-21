package com.itomas.dropwizard.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PalindromeFailure implements Palindrome {

	private String error;
	public PalindromeFailure() {
		// NOOP
	}
	public PalindromeFailure(String error) {
		this.error = error;
	}
	@JsonProperty
	public String getError() {
		return error;
	}
}
