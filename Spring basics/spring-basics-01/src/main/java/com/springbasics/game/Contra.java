package com.springbasics.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Contra implements GameConsole{

	@Override
	public String left() {
		// TODO Auto-generated method stub
		return "Billy turned Left";
	}

	@Override
	public String up() {
		return "Billy jumped";
	}

	@Override
	public String right() {
		return "Billy turned right";
	}

	@Override
	public String down() {
		return "Billy ducked";
	}

}
