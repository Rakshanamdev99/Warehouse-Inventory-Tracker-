package Com.warehouse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		                Warehouse warehouse = new Warehouse();

		                // Observer implementation
		                warehouse.addObserver(new AlertService() {
		                    @Override
		                    public void onLowStock(Product product) {
		                        System.out.println("🚨 ALERT: Low stock for " + product.getName() +
		                                           " – only " + product.getQuantity() + " left!");
		                    }
		                });

		                // Add product
		                Product laptop = new Product("P101", "Laptop", 0, 5);
		                warehouse.addProduct(laptop);

		                // Receive shipment
		                warehouse.receiveShipment("P101", 10);

		                // Fulfill order
		                warehouse.fulfillOrder("P101", 6);

		                // View inventory
		                warehouse.viewInventory();
    }  
}
		   
	
