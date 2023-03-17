package com.springbasics.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

		
		private GameConsole game;
		
		public GameRunner(@Qualifier("Classic") GameConsole game) {
			this.game = game;
		}

		public void run() {
			
			System.out.println("Running game: " + game);
	
			System.out.println(game.up());
			System.out.println(game.down());
			System.out.println(game.left());
			System.out.println(game.right());
		
			
		}

	}
