package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class Starter {
	@Configuration
	@ComponentScan( basePackageClasses = SimpleService.class )
	public static class AppConfig {		
	}
	
	public static void main( String[] args ) {
		try( GenericApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class ) ) {
			final SimpleService service = context.getBean( SimpleService.class );
			System.out.println( service.getResult() );
		}
	}
}
