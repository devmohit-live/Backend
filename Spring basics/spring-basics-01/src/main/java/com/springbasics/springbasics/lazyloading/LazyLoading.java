package com.springbasics.springbasics.lazyloading;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
class A{
	
}

@Component
class B{
	
	A a;
	
	public B(A a) {
		this.a = a;
		System.out.println("Class B's dependecny is being resolved");
	}
}




@Component
class C{
	
}

@Component
@Lazy
class D{
	
	C c;
	
	public D(C c) {
		this.c = c;
		System.out.println("Class D's dependecny is being resolved");
	}
}


@ComponentScan
@Configuration
public class LazyLoading {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(LazyLoading.class)){
			
			//Class D's dependency will only be loaded when class D will be in use
//			System.out.println(context.getBean(D.class));
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
	}
}
