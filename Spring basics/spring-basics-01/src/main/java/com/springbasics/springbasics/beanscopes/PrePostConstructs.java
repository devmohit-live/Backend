package com.springbasics.springbasics.beanscopes;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	
	private SomeDependency dependency;
	
	SomeClass(SomeDependency dependency){
		this.dependency = dependency;
		System.out.println("Dependecies are Wired");
	}
	
	@PostConstruct
	public void intialize() {
		System.out.println("Some intitlization work for dependency");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Some Cleanup work for dependency");
	}
	
}

@Component
class SomeDependency{
	
}


@ComponentScan
@Configuration
public class PrePostConstructs {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(PrePostConstructs.class)){
			
		}
		
	}
}
