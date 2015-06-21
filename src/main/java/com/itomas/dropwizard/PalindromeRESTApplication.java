package com.itomas.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PalindromeRESTApplication extends Application<PalindromeRESTConfiguration> {

	public static void main(String[] args) throws Exception {
        new PalindromeRESTApplication().run(args);
    }
	@Override
	public String getName() {
		return "palindrome-rest";
	}
	@Override
	public void run(PalindromeRESTConfiguration configuration,
			Environment environment) throws Exception {
		PalindromeRESTService service = new PalindromeRESTService();
		environment.jersey().register(service);
		
	}

}
