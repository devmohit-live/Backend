package com.springbasics.springbasics01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springbasics.game.GameConsole;
import com.springbasics.game.GameRunner;
import com.springbasics.game.Mario;


@Configuration
@ComponentScan("com.springbasics.game") //tell where to search for pojo implementation
public class GameConfig {

	
//	@Bean
//	public GameConsole game() {
//		var game = new Mario();
//		//so if the classes are not decorated by @Component : we have to manually create the object
//		return game;
//	}

//	@Bean
//	public GameRunner gameRunner(GameConsole game) {
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

}
