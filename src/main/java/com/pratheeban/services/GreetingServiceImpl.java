package com.pratheeban.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	public static final String HELLO_IZARDON = "Hello izardon!!!! - Original";

	@Override
	public String sayGreeting() {
		return HELLO_IZARDON;
	}
}
