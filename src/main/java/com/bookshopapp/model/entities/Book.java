package com.bookshopapp.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Book {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public int id;
	public String bookName;
	public double bookPrice;
	public String publisherName;
	public int publishingYear;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	
	
}
