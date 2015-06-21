package com.itomas.dropwizard;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itomas.dropwizard.pojo.Result;
import com.itomas.dropwizard.pojo.PalindromeFailure;
import com.itomas.dropwizard.pojo.PalindromeSuccess;

@Path("test/{word}")
@Produces(MediaType.APPLICATION_JSON)
public class PalindromeRESTService {

	public PalindromeRESTService() {
	}
	@GET
	public Response doGet(@PathParam("word") String word){
		return doPost(word);
	}
	@POST
	public Response doPost(@PathParam("word") String word) {
		try{
			return Response.status(Response.Status.OK).entity(createSuccessResult(isAPalindrome(word))).build();
		}
		catch(IllegalArgumentException e){ 
			Result palindromeFailure = createFailureResult(e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(palindromeFailure).build();
		}
	}
	/**
	 * Check whether a word is a palindrome or not
	 * @param word a string to check
	 * @return <code>true</code> if it is a palindromic string
	 * @throws IllegalArgumentException if the input string is null or empty or does not only contain alphabetic characters
	 */
	protected boolean isAPalindrome(String word) throws IllegalArgumentException{
		// check for palindrome constraints
		if(word!=null&&!"".equals(word)&&word.matches("^[a-zA-Z]*$")&&word.length()>2&&word.length()<31){
			int size = word.length();
			for(int index=0;index<(size/2);index++){
				if(word.charAt(index)!=word.charAt((size-1)-index)){
					return false;
				}
			}
			return true;
		}
		else{
			throw new IllegalArgumentException("The parameter must be a string of characters A-Z only.");
		}
	}
	protected Result createFailureResult(String msg) {
		return new Result(false,new PalindromeFailure(msg));
	}
	protected Result createSuccessResult(boolean isPalindrome) {
		return new Result(true,new PalindromeSuccess(isPalindrome));
	}

}
