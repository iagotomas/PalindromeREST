package com.itomas.dropwizard;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.itomas.dropwizard.pojo.PalindromeFailure;
import com.itomas.dropwizard.pojo.PalindromeSuccess;
import com.itomas.dropwizard.pojo.Result;

public class PalindromeRESTServiceTest {

	PalindromeRESTService service;
	@Before
	public void setUp() throws Exception {
		service = new PalindromeRESTService();
	}

	@Test
	public void testDoGet() {
		Response response = service.doGet("word");
		assertNotNull(response);
	}

	@Test
	public void testDoPost() {
		Response response = service.doPost("word");
		assertNotNull(response);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testIsAPalindrome_exception_null() {
		service.isAPalindrome(null);
		fail("IllegalArgumentException not thrown for an invalid word");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testIsAPalindrome_exception_contains_numbers() {
		service.isAPalindrome("word1");
		fail("IllegalArgumentException not thrown for an invalid word");
	}
	@Test
	public void testIsAPalindrome_false() {
		boolean result = service.isAPalindrome("word");
		assertFalse(result);
		result = service.isAPalindrome("palindrome");
		assertFalse(result);
		
	}
	@Test
	public void testIsAPalindrome_true() {
		boolean result = service.isAPalindrome("woow");
		assertTrue(result);
		result = service.isAPalindrome("wopow");
		assertTrue(result);
		result = service.isAPalindrome("wopowopow");
		assertTrue(result);
		result = service.isAPalindrome("wow");
		assertTrue(result);
	}

	@Test
	public void testCreateFailureResult() {
		String expected = "Some message";
		Result result = service.createFailureResult(expected);
		assertNotNull(result);
		assertNotNull(result.getResult());
		assertTrue(result.getResult() instanceof PalindromeFailure);
		assertEquals(expected, ((PalindromeFailure)result.getResult()).getError());
	}

	@Test
	public void testCreateSuccessResult() {
		boolean expected = true;
		Result result = service.createSuccessResult(expected);
		assertNotNull(result);
		assertNotNull(result.getResult());
		assertTrue(result.getResult() instanceof PalindromeSuccess);
		assertEquals(expected, ((PalindromeSuccess)result.getResult()).isAPalindrome());
	}

}
