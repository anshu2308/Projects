package com.nagarro.training.Entity;


import javax.persistence.*;


@Entity
public class Products {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int Sno;
	private String title;
	private int quantity;
	private int size;
	
	@Lob
	private byte[] image;
	
	@Transient
	private String base64Image;
	
	@ManyToOne
	private User user_id;
	
      public Products(int sno, String title,int quantity, int size,  User user_id) {
		super();
		Sno = sno;
		this.title=title;
		this.quantity = quantity;
		this.size = size;
		this.user_id = user_id;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getBase64Image() {
		
    	  return base64Image;
      }

	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public int getQuantity() {
		
		return quantity;	
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
		
		
	}

	public void setBase64Image(String base64Image ) {
           
		 this.base64Image =base64Image;
		
	}
}
