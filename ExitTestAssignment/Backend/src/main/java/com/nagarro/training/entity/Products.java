package com.nagarro.training.entity;

import java.util.Base64;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pName;
	private String pCode;
	private String pDescription;
	private double costPrice;
	private double discount;
	@Lob
	private byte[] image;
	@Transient
	private String base64Image;

	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	private double price;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private User user;

	public Products() {
		super();
	}

	public Products(String pName, String pCode, String pDescription, double costPrice, double discount,
			Category category, User user) {
		super();
		this.pName = pName;
		this.pCode = pCode;
		this.pDescription = pDescription;
		this.costPrice = costPrice;
		this.discount = discount;
		this.category = category;
		this.price = costPrice - (costPrice * discount / 100);
		this.user = user;
	}

	public Products(String pName, String pCode, String pDescription, double costPrice, double discount,
			Category category) {
		super();
		this.pName = pName;
		this.pCode = pCode;
		this.pDescription = pDescription;
		this.costPrice = costPrice;
		this.discount = discount;
		this.category = category;

	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(getImage());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice() {
		System.out.println("Called");
		this.price = costPrice - (costPrice * discount / 100);
	}

}
