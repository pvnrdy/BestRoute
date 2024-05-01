package com.bestroute.model;

public class DeliveryExecutive {
	private int id;
	private String name;
    private Location currentLocation;

    public DeliveryExecutive(int id, String name, Location currentLocation) {
    	this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Location getLocation() {
    	return this.currentLocation;
    }
}