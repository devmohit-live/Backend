package com.springbasics.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Classic")
public class Mario implements GameConsole{

	@Override
	public String left() {
		// TODO Auto-generated method stub
		return "Mario turned Left";
	}

	@Override
	public String up() {
		return "Mario jumped";
	}

	@Override
	public String right() {
		return "Mario turned right";
	}

	@Override
	public String down() {
		return "Mario ducked";
	}

}
