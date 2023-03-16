package com.springbasics.springbasics01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springbasics.game.GameConsole;
import com.springbasics.game.GameRunner;

public class AppGamingClient {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GameConfig.class)){
        	
//             System.out.println("Getting all beans:");
//             Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
             
        	context.getBean(GameConsole.class).up();
			
			context.getBean(GameRunner.class).run();
        } 

    }
}
