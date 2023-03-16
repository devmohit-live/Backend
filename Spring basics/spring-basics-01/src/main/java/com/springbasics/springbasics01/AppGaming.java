package com.springbasics.springbasics01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class AppGaming {
    public static void main(String[] args) {
        /*
        1. Create a Config file for Spring
        2. Create a context  using that config
        3. Use Beans via context
         */

        try(var context = new AnnotationConfigApplicationContext(GameApplicationConfig.class)){
        	
        	 System.out.println(context.getBean("name")); //getting by default fx name
             System.out.println(context.getBean("NamedBean"));//getting by specific given name
             System.out.println(context.getBean("NamedBean"));//getting by Type
             System.out.println(context.getBean("person"));
             System.out.println(context.getBean("person2"));
             System.out.println(context.getBean("person3"));
             
             // since there are multiple of same type : we are defining primary one 
             System.out.println(context.getBean(Person.class));//getting by Type
             
             System.out.println("Getting all beans:");
             Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

             
        } 

    }
}
    
    record Address(String street) {};
    
    record Person(String name, int age, Address address){};


@Configuration
class GameApplicationConfig{


    @Bean
    public String name(){
        return "Mohit";
    }

    @Bean(name = "NamedBean")
    public String name2(){
        return "Named Bean";
    }
    
    @Bean
    public int age() {
    	return 15;
    }
    
    @Bean
    @Primary
    public Address address() {
    	return new Address("Some Street");
    }
    
    @Bean
    @Qualifier("address2Qualifer")
    public Address address2() {
    	return new Address("Street2");
    }
    

    @Bean
    public Address address3() {
    	return new Address("Street2");
    }
    
    
    @Bean
    @Primary
    //Using existing beans
    public Person person() {
    	return new Person(name(),age(), new Address("AD1"));
    }
    
    @Bean
    //Using Constructor(the param name have to be same as given bean name(same fx name is using default bean name))
    public Person person2(String name, int age, @Qualifier("address2Qualifer") Address address) {
    	//using existing beans
    	// here are are provideing qualifier as address
    	return new Person(name,age, address);
    }
    
    @Bean
    //Using Constructor(the param name have to be same as given bean name(same fx name is using default bean name))
    public Person person3(String NamedBean, int age,Address address3) {
    	//using existing beans
    	return new Person(NamedBean,age, address3);
    }
    
   

}


