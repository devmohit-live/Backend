package com.springbasics.springbasics.CDI;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;


//CDI : Jakarta's Context and Dependency Injection


//@Component
@Named
class SomeClass{
	
	private SomeDependency dependency;

	public SomeDependency getDependency() {
		return dependency;
	}

//	@Autowired
	@Inject
	public void setDependency(SomeDependency dependency) {
		System.out.println("Setter injection is being done");
		this.dependency = dependency;
	}
	
	
	
}

//@Component
@Named
class SomeDependency{
	
}


@ComponentScan
@Configuration
public class CDIAnnotations {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CDIAnnotations.class)){
			System.out.println(context.getBean(SomeClass.class).getDependency());
			
			
			
		}
		
	}
}
