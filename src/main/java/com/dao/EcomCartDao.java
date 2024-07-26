package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomBean;
import com.bean.EcomCartBean;
import com.bean.ProductBean;

@Repository
public class EcomCartDao {

	@Autowired
	JdbcTemplate stmt;

	public void addToCart(EcomCartBean cbean) {

		EcomCartBean cart = null;

		try {
			System.out.println(cbean.getProductId());
			System.out.println(cbean.getUserId());
			cart = stmt.queryForObject("select * from cart where productId =? and userId = ?",
					new BeanPropertyRowMapper<>(EcomCartBean.class),
					new Object[] { cbean.getProductId(), cbean.getUserId() });
		} catch (Exception e) {

		}
		if (cart == null) {
		
			stmt.update("insert into cart (productId,userId,qty) values (?,?,?)",
					cbean.getProductId(), cbean.getUserId(), cbean.getQty());
		} else {
			stmt.update("update cart set qty = ? where productId = ? and userId = ?", cart.getQty() + 1,
					cart.getProductId(), cart.getUserId());
		}

	}

	public List<ProductBean> yourCart(String userId) {
		List<ProductBean> pbean = stmt.query("select * from products join cart using(productId) where userId = ?",
				new BeanPropertyRowMapper<>(ProductBean.class), new Object[] { userId });
		return pbean;
	}

	public void removeFromCart(Integer productId) {
		System.out.println("ProductUid" + productId);
		stmt.update("delete from cart where productId = ?", productId);
	}
}
