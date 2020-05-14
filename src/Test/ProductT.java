package Test;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Product")
public class ProductT {
	private Integer PetId;
	private String name;
	private String description;
	private byte[] coverImage;
	private String categoryId; 
	private String fileName; 	
	private double price ;//商品的單價unitPrice
	private int amount;
	private double discount;
	private  String biPhoto;
	
	private String  priceStr = null;
	
	@Transient
	public String getPriceStr() {
		return priceStr;
	}

	@Transient
	public String getBiPhoto() {
		return biPhoto;
	}


	public void setBiPhoto(String biPhoto) {
		this.biPhoto = biPhoto;
	}


	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	
	@Column(name="fileName")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String filename) {
		this.fileName = filename;
	}
	
	public ProductT() {
		
	}


	public ProductT(Integer petId, String name, String description, byte[] coverImage, String categoryId, String fileName,
			double price, int amount, double discount) {
		super();
		PetId = petId;
		this.name = name;
		this.description = description;
		this.coverImage = coverImage;
		this.categoryId = categoryId;
		this.fileName = fileName;
		this.price = price;
		this.amount = amount;
		this.discount = discount;
		
//		this.priceStr = priceStr;
	}

	@Id @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPetId() {
		return PetId;
	}
	public void setPetId(Integer PetId) {
		this.PetId = PetId;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "coverImage")
	public byte[] getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}
	
	@Column(name = "coverImage")
	public String getCategoryId() {
		return categoryId;
	}
	@Column(name = "category_id")
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name = "amount")
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Column(name = "discount")
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
