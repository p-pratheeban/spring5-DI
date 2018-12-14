package com.pratheeban.controllers;

import org.junit.Before;
import org.junit.Test;

import com.pratheeban.services.GreetingServiceImpl;

import static org.junit.Assert.assertEquals;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public  void setUp() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingServiceImpl = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.HELLO_IZARDON, propertyInjectedController.sayHello());
    }
}
