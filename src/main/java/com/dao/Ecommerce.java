package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomBean;


@Repository
public class Ecommerce {

	@Autowired
	JdbcTemplate stmt;
	public void insert(EcomBean ebean) {
		stmt.update("insert into ecomuser (id,firstname,email,password) values (?,?,?,?)",ebean.getId(),ebean.getFirstname(),ebean.getEmail(),ebean.getPassword());
	}
}
