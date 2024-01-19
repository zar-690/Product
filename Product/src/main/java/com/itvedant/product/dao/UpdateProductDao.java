package com.itvedant.product.dao;

public class UpdateProductDao {
	private String productName;
	private Integer price;
	private String description;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UpdateProductDao [productName=" + productName + ", price=" + price + ", description=" + description
				+ "]";
	}
}
