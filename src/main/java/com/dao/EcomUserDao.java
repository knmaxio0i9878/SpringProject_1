package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomBean;
import com.bean.UserBean;

@Repository
public class EcomUserDao {

	@Autowired
	JdbcTemplate stmt;
	
	public EcomBean authenticate(String email,String password) {
		
		try {
			EcomBean ebean = stmt.queryForObject("Select * from ecomuser where email = ? and password = ?",
					new BeanPropertyRowMapper<>(EcomBean.class),new Object[] {email,password});
			return ebean;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
