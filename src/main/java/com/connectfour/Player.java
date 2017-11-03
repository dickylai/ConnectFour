package com.connectfour;

public class Player {

	private String name;
	private String alias;

	public Player(String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	public String getName() {
		return name;
	}
	
	public String getAlias() {
		return alias;
	}
}
