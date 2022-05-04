package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//@Column(name="project")
	@ManyToOne(cascade = CascadeType.ALL)
	private Project project;
	
	//@Column(name="supplier")
	@ManyToOne(cascade = CascadeType.ALL)
	private User supplier;
	
	@Column(name="quantity")
	private int quantity;
	
	//@Column(name="product")
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	@Column(name="date")
	private String date;
	
	@Column(name="status")
	private String status;
	
	@Column(name="cost")
	private int cost;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getSupplier() {
		return supplier;
	}

	public void setSupplier(User supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
