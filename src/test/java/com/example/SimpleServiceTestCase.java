package com.example;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.example.Starter.AppConfig;

public class SimpleServiceTestCase {
	private GenericApplicationContext context;
	private SimpleService service;
	
	@Before
	public void setUp() {
		context = new AnnotationConfigApplicationContext( AppConfig.class );
		service = context.getBean( SimpleService.class );
	}
	
	@After
	public void tearDown() {
		context.close();
	}

	@Test
	public void testSampleTest() {	
		assertThat( service.getResult(), equalTo( "Result" ) );
	}	
}
