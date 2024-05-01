package com.bestroute.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private int id;
	private String name;
    private Location location;
    private int preparationTime;
    private List<Order> orders = new ArrayList<>();

    public Restaurant(int id, String name, Location location, int preparationTime) {
    	this.id = id;
        this.name = name;
        this.location = location;
        this.preparationTime = preparationTime;
    }

    public void assignOrder(Order order) {
        orders.add(order);
    }

    public Location getLocation() {
        return location;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getPreparationTime() {
    	return this.preparationTime;
    }
    
    public List<Order> getAllOrders() {
    	return this.orders;
    }
}