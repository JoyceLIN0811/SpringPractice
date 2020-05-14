package tw.pet.model.shopping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Component
@Table(name="Orders")
public class OrderBean {
	private Integer orderId;
	private Integer memberId;
	private Double totalAmount;
	private String shippingAddress;
	private String orderDate;
	private String state ;	//訂單狀態 //用來放入此訂單屬於哪個會員    
	//成立   逾時  取消  完成
	private Set<OrderDetailBean> orderDetail = new HashSet<OrderDetailBean>(); //用來存放訂單集合
	
	
	
	
	public OrderBean(Integer orderId, Integer memberId, Double totalAmount, String shippingAddress, String orderDate,
			Set<OrderDetailBean> orderDetail) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
	}
	public OrderBean() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column(name = "memberId")
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	@Column(name = "totalAmount")
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Column(name = "shippingAddress")
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@Column(name = "orderDate")
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Transient
	public Set<OrderDetailBean> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(Set<OrderDetailBean> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	
	
	
}
