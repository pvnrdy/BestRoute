package com.bestroute.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bestroute.model.Consumer;
import com.bestroute.model.DeliveryExecutive;
import com.bestroute.model.Location;
import com.bestroute.model.Order;
import com.bestroute.model.Restaurant;
import com.bestroute.test.TestApp;
import com.bestroute.util.AppConstants;
import com.bestroute.util.AppUtil;
import com.bestroute.util.DistanceCalculator;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Tomato Delivery App :)");

        System.out.println("Enter 'manual' for manual data entry or 'test' for test data:");
        String dataEntryMode = scanner.next();

        if (dataEntryMode.equalsIgnoreCase(AppConstants.MANUAL_MODE)) {
            double shortestTime = manualDataEntry(scanner);
            System.out.println("Total shortest delivery time: " + shortestTime + " hours");
        } else if (dataEntryMode.equalsIgnoreCase(AppConstants.TEST_MODE)) {
            TestApp.runTests();
        } else {
            System.out.println("Invalid input. Exiting...");
            scanner.close();
            return;
        }

        scanner.close();
    }

    public static double manualDataEntry(Scanner scanner) {
        System.out.println("How many awesome delivery agents are ready to conquer the world today?");
        int numAgents = scanner.nextInt();

        Map<Integer, DeliveryExecutive> agents = new HashMap<>();

        for (int i = 0; i < numAgents; i++) {
            System.out.println("Delivery ace joining the squad! What shall we call the Agent " + (i + 1) + "?");
            String agentName = scanner.next();
            System.out.println("Captain, it's time to chart Agent " + (i + 1) + "'s course! Enter the latitude first");
            double agentLatitude = scanner.nextDouble();
            System.out.println("Great! Now, could you please enter the longitude?");
            double agentLongitude = scanner.nextDouble();
            String locationName = agentName + AppConstants.LOCATION;
            Location agentLocation = new Location(locationName, agentLatitude, agentLongitude);
            agents.put(i + 1, new DeliveryExecutive(i + 1, agentName, agentLocation));
            System.out.println("WooHoo! We are done adding the " + (i + 1) + " delivery executive\n");
        }

        System.out.println("How many delicious restaurants are we working with us today?");
        int numRestaurants = scanner.nextInt();
        Map<Integer, Restaurant> restaurants = new HashMap<>();
        for (int i = 0; i < numRestaurants; i++) {
            System.out.println("What's the name of the restaurant " + (i + 1) + "?");
            String restaurantName = scanner.next();
            System.out.println("Where's this place? Gimme the latitude first:");
            double restaurantLatitude = scanner.nextDouble();
            System.out.println("And now, what's the longitude?");
            double restaurantLongitude = scanner.nextDouble();
            String locationName = restaurantName + AppConstants.LOCATION;
            Location restaurantLocation = new Location(locationName, restaurantLatitude, restaurantLongitude);
            System.out.println("How many minutes does it take to prepare this order?");
            int preparationTime = scanner.nextInt();
            Restaurant restaurant = new Restaurant(i + 1, restaurantName, restaurantLocation, preparationTime);
            restaurants.put(i + 1, restaurant);
            System.out.println("WooHoo! We are done adding the " + (i + 1) + " restaurant\n");
        }

        System.out.println("Alrighty, time to welcome some paying customers on board!\n");

        System.out.println("Let's roll out the red carpet! How many fabulous customers are we expecting today?");
        int numCustomers = scanner.nextInt();
        Map<Integer, Consumer> customers = new HashMap<>();
        for (int i = 0; i < numCustomers; i++) {
            System.out.println("Captain, let's jot down the name of Customer " + (i + 1) + ":");
            String customerName = scanner.next();
            System.out.println("Where's this customer's spot on the map? Gimme the latitude first:");
            double customerLatitude = scanner.nextDouble();
            System.out.println("And now, what's the longitude?");
            double customerLongitude = scanner.nextDouble();
            String locationName = customerName + AppConstants.LOCATION;
            Location customerLocation = new Location(locationName, customerLatitude, customerLongitude);
            Consumer consumer = new Consumer(i + 1, customerName, customerLocation);
            customers.put(i + 1, consumer);
            System.out.println("WooHoo! We are done adding the " + (i + 1) + " customer\n");
        }

        System.out.println("WooHoo! We are almost ready to generate our first order and calculate the shortest path\n");

        System.out.println("How many orders do we have today?");
        int numOrders = scanner.nextInt();
        Map<Integer, Order> orders = new HashMap<>();
        for (int i = 0; i < numOrders; i++) {
            System.out.println("Which customer placed this order, you can enter the customer ID?");
            int customerID = scanner.nextInt();
            System.out.println("Which restaurant will be delivering this order, you can enter the restaurant ID?");
            int restaurantID = scanner.nextInt();
            System.out.println("Which delivery agent will be delivering this order, you can enter the delivery agent ID?");
            int deliveryAgentID = scanner.nextInt();
            Consumer customer = AppUtil.getCustomerById(customers, customerID);
            Restaurant restaurant = AppUtil.getRestaurantById(restaurants, restaurantID);
            DeliveryExecutive deliveryExecutive = AppUtil.getDeliveryExecutiveById(agents, deliveryAgentID);
            if (customer == null) {
                System.out.println("Customer doesn't exist :-");
            }
            if (restaurant == null) {
                System.out.println("Restaurant doesn't exist :-");
            }
            if (deliveryExecutive == null) {
                System.out.println("Delivery Executive doesn't exist :-");
            }

            if (customer != null && restaurant != null && deliveryExecutive != null) {
                Order order = new Order(i + 1, customer, deliveryExecutive, restaurant, customer.getLocation());
                orders.put(i + 1, order);
            }
            
            System.out.println("WooHoo! We are done adding the " + (i + 1) + " order\n");
        }

        System.out.println("Enter the delivery agent for who we have to check the shortest route?");
        int deliveryAgentID = scanner.nextInt();
        double shortestTime = 0.0;
        shortestTime = calculateShortestTime(deliveryAgentID, orders);

        return shortestTime;
    }

    public static double calculateShortestTime(int deliveryAgentID, Map<Integer, Order> orders) {
        double totalShortestTime = 0.0;
        double deliveryAgentSpeed = 20; // Average speed of delivery agent in km/hr
        for (Order order : orders.values()) {
            DeliveryExecutive orderDelAgent = order.getAgent();
            Restaurant restaurant = order.getRestaurant();
            Consumer customer = order.getCustomer();
            if (orderDelAgent.getId() == deliveryAgentID) {
                double distAR = DistanceCalculator.calculateDistance(orderDelAgent.getLocation().getLatitude(), orderDelAgent.getLocation().getLongitude(), restaurant.getLocation().getLatitude(), restaurant.getLocation().getLongitude());
                double distRC = DistanceCalculator.calculateDistance(restaurant.getLocation().getLatitude(), restaurant.getLocation().getLongitude(), customer.getLocation().getLatitude(), customer.getLocation().getLongitude());
                int preparationTime = restaurant.getPreparationTime();
                double timeAR = distAR / deliveryAgentSpeed;
                double orderTime = timeAR + preparationTime / 60 + distRC / deliveryAgentSpeed;
                totalShortestTime += orderTime; // Accumulate the total time
            }
        }

        return totalShortestTime;
    }
}
