package com.joy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cars {
	@Id
	private int id;
	private String source;
	@Column(unique=true)
	private String registrationnumber;
	
	private String model;
	private int seater;
	@Column(nullable=true)
	private int bookedfromdate;
	@Column(nullable=true)
	private int bookedtilldate;
	private String photo;
	private double price;
	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRegistrationnumber() {
		return registrationnumber;
	}

	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}


	public int getBookedfromdate() {
		return bookedfromdate;
	}

	public void setBookedfromdate(int bookedfromdate) {
		this.bookedfromdate = bookedfromdate;
	}

	public int getBookedtilldate() {
		return bookedtilldate;
	}

	public void setBookedtilldate(int bookedtilldate) {
		this.bookedtilldate = bookedtilldate;
	}



	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeater() {
		return seater;
	}

	public void setSeater(int seater) {
		this.seater = seater;
	}

	public int getId() {
		return id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
