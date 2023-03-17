package com.springbasics.springbasics01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class BasicConfigClient {
    public static void main(String[] args) {
        /*
        1. Create a Config file for Spring
        2. Create a context  using that config
        3. Use Beans via context
         */

        try(var context = new AnnotationConfigApplicationContext(BasicConfig.class)){
        	
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
