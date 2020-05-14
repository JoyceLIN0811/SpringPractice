package tw.pet.model.shopping;

import org.springframework.stereotype.Component;

//@Component
public class CartBean {
	private int quantity; // 數量
	private double price;// 總價格
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartBean(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	
}
