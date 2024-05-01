package com.bestroute.model;

public class Consumer {
	private int id;
	private String name;
	private Location location;
	
	public Consumer(int id, String name, Location location)  {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Location getLocation() {
		return this.location;
	}
}