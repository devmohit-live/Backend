package com.springbasics.springbasics01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class BasicConfig {
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
record Address(String street) {};

record Person(String name, int age, Address address){};

