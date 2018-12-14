package com.pratheeban.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("de")
public class PrimaryGermanGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayGreeting() {
		return greetingRepository.getGermanGreeting();
	}

}
