package com.arthur.redisstudy.credits.service;

public interface SignInService {
	
	/**
	 * Do the Sign In work
	 * @param userId
	 * @return  Sign In point this time, or 0 if you have signed already today. 
	 */
	public Long signIn(Long userId);

}
