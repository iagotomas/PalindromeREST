package com.itomas.dropwizard.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	private boolean success;
	private Palindrome result;
	public Result() {
		// NOOP
	}
	
    public Result(boolean success,Palindrome result) {
		this.success = success;
		this.result = result;
	}
    @JsonProperty
    public Palindrome getResult() {
		return result;
	}

	@JsonProperty
	public boolean success() {
		return success;
	}
}
