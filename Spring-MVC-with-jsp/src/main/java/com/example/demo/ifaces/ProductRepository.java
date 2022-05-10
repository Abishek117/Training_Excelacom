package com.example.demo.ifaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository
public class ProductRepository implements CrudRepository<Product>
{
	
	private JdbcTemplate template;
	
	@Autowired
	public ProductRepository(JdbcTemplate template) {
		super();
		this.template = template;
	}

	
	@Override
	public int add(Product t) 
	{
		String sql = "insert into abi_product17 values(?,?,?)";
		return template.update(sql, t.getProductId(), t.getProductName(),t.getPrice());
	}

	

	@Override
	public List<Product> findAll() 
	{
		
		String sql = "select * from abi_product17";
		return (template.query(sql,  BeanPropertyRowMapper.newInstance(Product.class)));
	}


	@Override
	public Product findById(int id) {
		String sql1 = "select * from abi_product17 where product_id = ?";
		try
		{
			return (template.queryForObject(sql1, BeanPropertyRowMapper.newInstance(Product.class),id));
		}
		catch(IncorrectResultSizeDataAccessException e)
		{
			return null;
			
		}
		
	}


	@Override
	public int update(Product t) {
		
		String sql3 = "update abi_product17 set price = ? where product_id = ?";
		return template.update(sql3, t.getPrice(),t.getProductId());
	}


	@Override
	public int remove(int id) {
		
		String sql2 = "select * from abi_product17 where product_id = ?";
		return template.update(sql2,id);
		
	}
	
	

}
