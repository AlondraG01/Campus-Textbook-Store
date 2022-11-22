public class Textbook {
	private int SKU;
	private String name;
	private double price;
	private int qty;
	
	public Textbook (int sku, String n, double p, int qty) {
		this.SKU = sku;
		this.name = n;
		this.price = p;
		this.qty = qty;
	}
	
	public int getSKU() {
		return this.SKU;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getQty() {
		return this.qty;
	}
}
