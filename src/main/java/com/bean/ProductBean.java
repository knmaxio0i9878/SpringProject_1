package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class ProductBean {

	private Integer productId;
	private String productName;
	private String category;
	private String qty;
	private Float price;
	private MultipartFile masterImage;
	private String productimgpath;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public MultipartFile getMasterImage() {
		return masterImage;
	}
	public void setMasterImage(MultipartFile masterImage) {
		this.masterImage = masterImage;
	}
	public String getProductimgpath() {
		return productimgpath;
	}
	public void setProductimgpath(String productimgpath) {
		this.productimgpath = productimgpath;
	}
	
	
}
