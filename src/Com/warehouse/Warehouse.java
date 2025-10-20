package Com.warehouse;

import java.util.*;

public class Warehouse {
	
	    private Map<String, Product> inventory = new HashMap<>();
	    private List<AlertService> observers = new ArrayList<>();

	    // Add observer
	    public void addObserver(AlertService observer) {
	        observers.add(observer);
	    }

	    // Add product
	    public void addProduct(Product product) {
	        inventory.put(product.getId(), product);
	        System.out.println("✅ Product added: " + product.getName());
	    }

	    // Receive shipment
	    public void receiveShipment(String productId, int amount) {
	        Product product = inventory.get(productId);
	        if (product != null) {
	            product.increaseQuantity(amount);
	            System.out.println("📦 Shipment received for " + product.getName() + ": +" + amount);
	        } else {
	            System.out.println("❌ Invalid Product ID: " + productId);
	        }
	    }

	    // Fulfill customer order
	    public void fulfillOrder(String productId, int amount) {
	        Product product = inventory.get(productId);
	        if (product != null) {
	            boolean success = product.decreaseQuantity(amount);
	            if (success) {
	                System.out.println("🛒 Order fulfilled for " + product.getName() + ": -" + amount);
	                if (product.getQuantity() < product.getThreshold()) {
	                    triggerAlert(product);
	                }
	            } else {
	                System.out.println("⚠ Insufficient stock for " + product.getName());
	            }
	        } else {
	            System.out.println("❌ Invalid Product ID: " + productId);
	        }
	    }

	    // Trigger low-stock alert
	    private void triggerAlert(Product product) {
	        for (AlertService observer : observers) {
	            observer.onLowStock(product);
	        }
	    }

	    // View inventory
	    public void viewInventory() {
	        System.out.println("\n📋 Current Inventory:");
	        for (Product p : inventory.values()) {
	            System.out.println(p.getId() + " | " + p.getName() + " | Qty: " + p.getQuantity());
	        }
	    }
}
	
