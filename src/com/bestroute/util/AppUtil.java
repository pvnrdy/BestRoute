package com.bestroute.util;

import java.util.Map;

import com.bestroute.model.Consumer;
import com.bestroute.model.DeliveryExecutive;
import com.bestroute.model.Restaurant;

public class AppUtil {
	public static Consumer getCustomerById(Map<Integer, Consumer> customersMap, int consumerID) {
        return customersMap.get(consumerID); 
    }
	
	public static Restaurant getRestaurantById(Map<Integer, Restaurant> restaurantsMap, int restaurantID) {
        return restaurantsMap.get(restaurantID); 
    }
	
	public static DeliveryExecutive getDeliveryExecutiveById(Map<Integer, DeliveryExecutive> deliveryExecutives, int deliveryExecutiveID) {
        return deliveryExecutives.get(deliveryExecutiveID); 
    }
}
