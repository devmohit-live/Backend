package com.springbasics.springbasics.prePostsConstructs;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//Singleton
@Component
class A{
	
}


//Prototype
//Useful in stateful bean : ex holding a user's info or user related information
@Component()
@Scope(value =  ConfigurableBeanFactory.SCOPE_PROTOTYPE)

class B{
	
}



@ComponentScan
@Configuration
public class BeanScopes {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(BeanScopes.class)){
			System.out.println(context.getBean(A.class));
			System.out.println(context.getBean(A.class));
			
			System.out.println(context.getBean(B.class));
			System.out.println(context.getBean(B.class));
			System.out.println(context.getBean(B.class));
		}
		
	}
}
