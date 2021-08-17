package com.training;

public class Book {
	
	private long isbn;
	private String title;
	private double price;
	private String category;
	private double stock;
	public Book(long isbn, String title, double price, String category, double stock) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.category = category;
		this.stock = stock;
	}
	public Book() {
		super();
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", category=" + category + ", stock="
				+ stock + "]";
	}
	
	
	

}
