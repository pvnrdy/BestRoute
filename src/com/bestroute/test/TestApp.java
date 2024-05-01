package com.bestroute.test;

import java.util.HashMap;
import java.util.Map;

import com.bestroute.app.MainApplication;
import com.bestroute.model.Consumer;
import com.bestroute.model.DeliveryExecutive;
import com.bestroute.model.Location;
import com.bestroute.model.Order;
import com.bestroute.model.Restaurant;
import com.bestroute.util.AppConstants;

public class TestApp {
    private static Map<Integer, Consumer> customers = new HashMap<>();
    private static Map<Integer, Restaurant> restaurants = new HashMap<>();
    private static Map<Integer, DeliveryExecutive> agents = new HashMap<>();
    private static Map<Integer, Order> orders = new HashMap<>();

    public static void runTests() {
        // Populate sample data
        populateSampleData();
        testShortestDeliveryTimeForAgent1();
    }

    private static void populateSampleData() {
        // Populate sample consumers
        Consumer customer1 = new Consumer(1, "Alice", new Location("Alice's Location", 12.934533, 77.629631));
        Consumer customer2 = new Consumer(2, "Bob", new Location("Bob's Location", 12.927923, 77.627108));
        customers.put(1, customer1);
        customers.put(2, customer2);

        // Populate sample restaurants
        Restaurant restaurant1 = new Restaurant(1, "Restaurant A", new Location("Restaurant A Location", 12.934633, 77.631331), 30);
        Restaurant restaurant2 = new Restaurant(2, "Restaurant B", new Location("Restaurant B Location", 12.928123, 77.628608), 25);
        restaurants.put(1, restaurant1);
        restaurants.put(2, restaurant2);

        // Populate sample delivery executives
        DeliveryExecutive agent1 = new DeliveryExecutive(1, "Aman", new Location("Aman's Location", 12.934733, 77.630131));
        agents.put(1, agent1);

        // Populate sample orders
        Order order1 = new Order(1, customer1, agent1, restaurant1, customer1.getLocation());
        Order order2 = new Order(2, customer2, agent1, restaurant2, customer2.getLocation());
        orders.put(1, order1);
        orders.put(2, order2);
    }

    private static void testShortestDeliveryTimeForAgent1() {
        double shortestTimeAgent1 = MainApplication.calculateShortestTime(1, orders);
        assertEqual(shortestTimeAgent1, 0.061846);
    }

    private static void assertEqual(double actualValue, double expectedValue) {
        if (Math.abs(actualValue - expectedValue) < AppConstants.TEST_THRESHOLD) {
            System.out.println("Assertion passed: Calculated shortest time matches the expected value.");
        } else {
            System.out.println("Assertion failed: Calculated shortest time does not match the expected value.");
        }
    }
}
