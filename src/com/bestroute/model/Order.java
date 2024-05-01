package com.bestroute.model;

public class Order {
	private int id;
    private Consumer consumer;
    private DeliveryExecutive agent;
    private Restaurant restaurant;
    private Location destination;
    
    public Order(int id, Consumer consumer, DeliveryExecutive agent, Restaurant restaurant, Location destination) {
    	this.id = id;
        this.consumer = consumer;
        this.agent = agent;
        this.restaurant = restaurant;
        this.destination = destination;
    }
    
    public int getId() {
    	return this.id;
    }

    public Consumer getCustomer() {
        return consumer;
    }

    public DeliveryExecutive getAgent() {
        return agent;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    
    public Location getDeliveryLocation() {
    	return destination;
    }
}