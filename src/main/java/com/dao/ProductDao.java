package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	
	@Autowired
	JdbcTemplate stmt;
	public void addProduct(ProductBean pbean) {
		stmt.update("insert into products (productName,category,qty,price) values (?,?,?,?)",
				pbean.getProductName(),pbean.getCategory(),pbean.getQty(),pbean.getPrice());
	}
	
	public List<ProductBean> getAllProduct(){
		
		List<ProductBean> list = stmt.query("select * from products",
				new BeanPropertyRowMapper<ProductBean>(ProductBean.class));
		return list;	
	}
	
	public void deleteProduct(Integer productId) {
		stmt.update("delete from products where productId = ?",  productId);
	}
	
	public void deleteProductName(String productName) {
		stmt.update("delete from products where productName = ?",  productName);
	}
}
