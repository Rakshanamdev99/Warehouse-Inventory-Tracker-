package Com.warehouse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    Warehouse warehouse = new Warehouse();

		    warehouse.addObserver(new AlertService() {
		        @Override
		        public void onLowStock(Product product) {
		            System.out.println("🚨 ALERT: Low stock for " + product.getName() +
		                               " – only " + product.getQuantity() + " left!");
		        }
		    });

		    Product laptop = new Product("P101", "Laptop", 0, 5);
		    Product phone = new Product("P102", "Smartphone", 2, 3);
		    Product mouse = new Product("P103", "Wireless Mouse", 10, 5);

		    warehouse.addProduct(laptop);
		    warehouse.addProduct(phone);
		    warehouse.addProduct(mouse);

		    warehouse.receiveShipment("P101", 10);
		    warehouse.receiveShipment("P102", 5);

		    warehouse.fulfillOrder("P101", 6);
		    warehouse.fulfillOrder("P102", 4);
		    warehouse.fulfillOrder("P103", 6);

		    warehouse.viewInventory();
		}

}	

		

	
		       
