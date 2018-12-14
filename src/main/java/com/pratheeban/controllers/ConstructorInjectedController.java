package com.pratheeban.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.pratheeban.services.GreetingService;

@Controller
public class ConstructorInjectedController {
	private GreetingService greetingService;

	// @Autowired is optional, spring automatically wires up for constructor
	public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.sayGreeting();
	}
}
