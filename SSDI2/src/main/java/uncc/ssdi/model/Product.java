package uncc.ssdi.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


	@Entity
	@Table(name = "PRODUCTS")
	
	public class Product implements Serializable, IProduct {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column
	    private String name;
	    
	    @Column
	    private String description;
	    
	    @Column
	    private Double basePrice;
	    
	    @Column
	    private Double minPrice;
	    
	    @Column
	    private int quantity;

	   /*public User getUser() {
			return user;
		}




		public void setUser(User user) {
			this.user = user;
		}*/

		/* @OneToMany
	    @JoinColumn(name ="userid")
	    private Product userid;*/
	   /* @ManyToOne
	    @JoinColumn(name="userid")
		private User user;*/
	    
	    @Column
	    private String imageurl;
	    
	    @Column
	    private int sellerid;
	    
	    public int getSellerid() {
			return sellerid;
		}




		public void setSellerid(int sellerid) {
			this.sellerid = sellerid;
		}




		public Product() {
	    	
	    }
	   

	   

	/* @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;*/

	   /* @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;*/

		


		public int getId() {
			return id;
		}

	/*	public Product(double id, @NotBlank String name, @NotBlank String description, @NotBlank double basePrice,
			@NotBlank double minPrice, @NotBlank int quantity, @NotBlank String sellerId, @NotBlank String imageurl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.basePrice = basePrice;
		this.minPrice = minPrice;
		this.quantity = quantity;
		this.sellerId = sellerId;
		this.imageurl = imageurl;
	}*/




		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public  Double getBasePrice() {
			return basePrice;
		}

		public void setBasePrice( Double basePrice) {
			this.basePrice = basePrice;
		}

		public Double getMinPrice() {
			return minPrice;
		}
		
		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		
		public String getImageurl() {
			return imageurl;
		}

		public void setMinPrice(Double minPrice) {
			this.minPrice = minPrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}




		public Product(int id, String name, String description, Double basePrice, Double minPrice, int quantity,
				String imageurl, int sellerid) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.basePrice = basePrice;
			this.minPrice = minPrice;
			this.quantity = quantity;
			this.imageurl = imageurl;
			this.sellerid = sellerid;
		}




		
		/*public String getSellerId() {
			return sellerId;
		}

		public void setSellerId(String sellerId) {
			this.sellerId = sellerId;
		}*/

	
	    
	}
