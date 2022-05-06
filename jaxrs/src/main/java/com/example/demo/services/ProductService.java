package com.example.demo.services;
import java.sql.*;
import java.util.*;

import com.example.util.ConnectionFactory;




public class ProductService {
	
	private Connection con;
	
	public ProductService() {
		this.con = ConnectionFactory.getOracleConnection();
	}
	
	public int update(String productName,double newPrice) {
		int rowsUpdated = 0;
		return rowsUpdated;
	}
	
	

	
	//delete
	public int deleteById(int id) {
		
		String sql = "delete from abi_product17 where product_id =?";
		
		int rowsDeleted = 0;
		try(PreparedStatement pstmt = con.prepareStatement(sql))
		{
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rowsDeleted;
		
	}
	
	
	
	//findbyID
	public Optional<Product> findById(int id){
		
		Optional<Product> obj=Optional.empty();
		String sql="Select * from abi_product17 where product_id=?";
		try(PreparedStatement pstmt=con.prepareStatement(sql)){
			
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int productId=rs.getInt("PRODUCT_ID");
				String productName=rs.getString("PRODUCT_NAME");
				double price=rs.getDouble("PRICE");
			
				Product prod=new Product(productId, productName, price);
				obj=Optional.of(prod);
			}
						
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
		
		 
		
	//add
	public int addProduct(Product entity) {
		int rowAdded = 0;
		
		String sql = "insert into abi_product17 values(?,?,?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1,entity.getProductId());

			pstmt.setString(2,entity.getProductName());

			pstmt.setDouble(3,entity.getPrice());
			
			rowAdded = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return rowAdded;
	}
		
	
	
    //findAll
	public List<Product> findAll(){
		
		List<Product> productList = new ArrayList<Product>();
		
		String sql ="select * from abi_product17";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				int productId =rs.getInt("product_id");
				String productName =rs.getString("product_name");
				double price =rs.getDouble("price");
				
				Product prod =new Product(productId,productName,price);
				productList.add(prod);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	
	
	//Update
	public int updatePriceById(int id,double newPrice)
	{
		int rowsUpdated=0;
		String sql="update abi_product17 set price= ? where product_id=?";
		try(PreparedStatement pstmt=con.prepareStatement(sql))
		{
			pstmt.setDouble(1,newPrice);
			pstmt.setInt(2,id);
					
	            rowsUpdated=pstmt.executeUpdate();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
					
		return rowsUpdated;	
			
		}
	
	
	
	
	
	
	
	
	
	/*
public void usingTxn(Product prd1, Product prd2) {
		
	String sql = "insert into abi_product17 values (?,?,?)";
	String sql1 = "insert into abi_product17 values (?,?,?)";
		
		try(PreparedStatement pstmt1 = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql1)){
				 
			
			con.setAutoCommit(false);
			
			pstmt1.setInt(1, prd1.getProductId());
			pstmt1.setString(2, prd1.getProductName());
			pstmt1.setDouble(3, prd1.getPrice());
			
			int rowAdded1 = pstmt1.executeUpdate();
			
			pstmt2.setInt(1, prd2.getProductId());
			pstmt2.setString(2, prd2.getProductName());
			pstmt2.setDouble(3, prd2.getPrice());
			
			int rowAdded2 = pstmt2.executeUpdate();
			
			if(prd2.getPrice()>prd1.getPrice()) {
				con.commit();
			}else {
				con.rollback();
			}
			
			System.out.println("Row Added:"+ rowAdded1+","+rowAdded2);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/
		
	}