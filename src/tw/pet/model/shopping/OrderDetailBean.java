package tw.pet.model.shopping;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//@Entity
//@Component
//@Table(name = "OrderDetail")
public class OrderDetailBean {
	private Integer seqno;
	private Integer orderNo;
	private	Integer PetId;
	private String description;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	
	
	
}
